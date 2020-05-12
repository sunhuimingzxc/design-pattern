package com.shm.singleton;

/**
 * 双检索单例
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton(){};

    public static DoubleCheckSingleton getInstance() {

        if(instance == null){//锁外判断，是为了避免每次创建实例都加锁，影响性能，这是对懒汉单例的优化，懒汉单例每次都上锁
            synchronized (DoubleCheckSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
