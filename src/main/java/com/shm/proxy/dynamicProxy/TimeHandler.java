package com.shm.proxy.dynamicProxy;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        System.out.println("运行开始LOG。。。");
        try {
            m.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("运行结束LOG。。。");

    }
}
