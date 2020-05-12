package com.shm.singleton;

/**
 * 饿汉式单例/预加载
 */
public class HungrySingleton {

    public static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){};

    public static HungrySingleton getInstance(){
        return instance;
    }

}
