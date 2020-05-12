package com.shm.singleton;

/**
 * 懒汉式单例/懒加载
 */
public class LazySingleton {
    public static LazySingleton instance = null;

    public LazySingleton(){}

    public synchronized static LazySingleton getInstance(){
        if(instance != null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
