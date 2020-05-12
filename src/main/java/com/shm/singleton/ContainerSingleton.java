package com.shm.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例 spring中的单例
 */
public class ContainerSingleton {

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    private ContainerSingleton(){};

    public static Object getBean(String className){
        synchronized (ioc){

            try{
                if(!ioc.containsKey(className)){
                    Object obj = null;
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                    return obj;
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            return ioc.get(className);

        }

    }
}
