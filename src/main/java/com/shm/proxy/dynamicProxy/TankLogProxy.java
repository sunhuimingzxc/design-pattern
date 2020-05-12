package com.shm.proxy.dynamicProxy;
import java.lang.reflect.Method;
public class TankLogProxy implements com.shm.proxy.dynamicProxy.Moveable {
   com.shm.proxy.dynamicProxy.Moveable m;
   com.shm.proxy.dynamicProxy.InvocationHandler h;
   public TankLogProxy(com.shm.proxy.dynamicProxy.InvocationHandler h){
	    this.h = h;
   }
	@Override
	public void move(){
      try{
          Method m = com.shm.proxy.dynamicProxy.Moveable.class.getMethod("move");
          h.invoke(this, m);
      }catch(Exception e){
          e.printStackTrace();
      }
	}
}
