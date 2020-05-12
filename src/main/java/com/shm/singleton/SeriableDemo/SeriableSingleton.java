package com.shm.singleton.SeriableDemo;

import com.shm.singleton.HungrySingleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 */
public class SeriableSingleton implements Serializable {

    private static final SeriableSingleton instance = new SeriableSingleton();

    private SeriableSingleton(){};

    public static SeriableSingleton getInstance(){
        return instance;
    }

/*
    //实现此方法，就不能够通过序列化破坏单例；它内部会用这个方法的返回值覆盖反序列化出来的对象
    private Object readResolve(){
        return instance;
    }
*/


}
