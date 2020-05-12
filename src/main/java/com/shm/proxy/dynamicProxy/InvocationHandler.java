package com.shm.proxy.dynamicProxy;

import java.lang.reflect.Method;

/**
 * 负责对 目标业务/被代理类 进行增强
 */
public interface InvocationHandler {

    public void invoke(Object o, Method m);

}
