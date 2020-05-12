package com.shm.singleton;

import java.lang.reflect.Constructor;

/**
 * 静态内部类单例(最优的单例)
 *  懒加载
 *  线程安全
 *  无锁
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){
        //防止反射破坏单例
        if(InnerClass.instance  != null){
            throw new RuntimeException("不允许构建多个实例");
        }
    };

    public static InnerClassSingleton getInstance(){
        return InnerClass.instance;
    }

    public static class InnerClass{
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }
}

/**
 * 通过反射破坏单例
 */
class Main{
    public static void main(String[] args) {
        try {
            //通过反射破坏单例
            Constructor constructor = InnerClassSingleton.class.getDeclaredConstructor(null);
            constructor.setAccessible(true);//忽略权限检查
            Object obj1 = (Object)constructor.newInstance();

            //通过单例正常获取的类
            Object obj2 = InnerClassSingleton.getInstance();

            System.out.println(obj1 == obj2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}