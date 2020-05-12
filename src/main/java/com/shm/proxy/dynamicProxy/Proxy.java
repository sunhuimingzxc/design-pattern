package com.shm.proxy.dynamicProxy;

import com.shm.proxy.dynamicProxy.InvocationHandler;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 负责创建代理对象
 *
 * 1.实现目标的接口
 * 2.实现目标的方法
 * 3.创建构造器
 * 4.实例化代理对象，传入handler
 */
public class Proxy {

    public static Object newProxyInstance(Class inter, InvocationHandler invocationHandler) throws Exception{
        String rt = "\r\n"; //回车换行
        String method = "";
        Method[] methods = inter.getMethods();
        for(Method me : methods){
            method=
                     "	@Override"+ rt +
                     "	public void " + me.getName() + "(){" + rt +
                     "      try{" + rt +
                     "          Method m = " + inter.getName() + ".class.getMethod(\""+ me.getName() + "\");" + rt +
                     "          h.invoke(this, m);" + rt +
                     "      }catch(Exception e){"+ rt +
                     "          e.printStackTrace();" + rt +
                     "      }" + rt +
                     "	}" + rt +
                     "}" + rt ;
        }

        String src =
                "package com.shm.proxy.dynamicProxy;" + rt +
                "import java.lang.reflect.Method;" + rt +
                "public class TankLogProxy implements " + inter.getName() +" {" + rt +
                "   "+inter.getName()+" m;"+ rt +
                "   com.shm.proxy.dynamicProxy.InvocationHandler h;" + rt +
                "   public TankLogProxy(com.shm.proxy.dynamicProxy.InvocationHandler h){" + rt +
                "	    this.h = h;" + rt +
                "   }"+ rt + method;

        String fileName = System.getProperty("user.dir") + "/src/main/java/com/shm/Proxy/dynamicProxy/TankLogProxy.java";
        File f= new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); //获得java编译器 也就是javac
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null); //需要初始化文件管理者，用它来管理文件
        Iterable units = fileMgr.getJavaFileObjects(fileName);//需要编译的java文件。获得java文件，可以获得多个，产生java文件的对象。Iterable相当与数组
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);//一个编译的任务，一次可编译多个文件
        t.call(); //调用
        fileMgr.close();//关闭

        //load到内存
        URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") + "/src")}; //URL 地址类。file:/" + "d:/src/是url的格式
        URLClassLoader ul = new URLClassLoader(urls);  //将硬盘上的文件加载到内存中的类，urls是到哪个路径上去load
        Class proxyClass = ul.loadClass("com.shm.proxy.dynamicProxy.TankLogProxy"); //load具体的类
        //System.out.println(c);

        //new实例调用
        Constructor ctr = proxyClass.getConstructor(InvocationHandler.class); //拿到构造方法，这个构造方法的参数是Moveable类型，所以就拿到了TankLogProxy类的TankLogProxy(Moveable m)的构造方法
        Object m = ctr.newInstance(invocationHandler); //
        //m.move();
        //m.move();
        return m;
    }
}
