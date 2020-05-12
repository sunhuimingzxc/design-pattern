package com.shm.proxy.dynamicProxy;


import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 仿JDK动态代理
 * 调用者
 *
 * 调用代理类的move()相当于调用了InvocationHandler的invoke(),因为在实例化代理类的时候将InvocationHandler传入了代理类的构造器，然后再代理类的move()中调用了InvocationHandler.invoke(代理类本身，被代理类的方法);
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Moveable tank = new Tank();
        InvocationHandler handler = new TimeHandler(tank);
        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, handler);
        m.move();


    }
}
