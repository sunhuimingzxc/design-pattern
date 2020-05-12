package com.shm.singleton;

public class Test {
    public static void main(String[] args) {

        Object obj = ContainerSingleton.getBean("com.shm.singleton.ContainerSingleton");
        System.out.println(obj);

    }
}
