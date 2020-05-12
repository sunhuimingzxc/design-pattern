package com.shm.singleton;

/**
 * 枚举单例
   1.编译后为饿汉式单例，线程安全，
 * 2.不能通过反射或反序列化破解，因为JDK层面就保证了，如果是枚举，调用反射的构造器就会抛异常
 */
public enum EnumSingleton {

    INSTANCE;

    public static EnumSingleton  getInstance(){
        return INSTANCE;
    }

    //用于扩展
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
