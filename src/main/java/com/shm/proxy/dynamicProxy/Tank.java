package com.shm.proxy.dynamicProxy;


/**
 * 目标对象实现类/被代理对象实现类
 */
public class Tank implements Moveable {
    public void move() {
        System.out.println("坦克移动");
    }
}
