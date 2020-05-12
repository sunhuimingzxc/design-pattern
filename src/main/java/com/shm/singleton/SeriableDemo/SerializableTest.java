package com.shm.singleton.SeriableDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 通过序列化破坏单例
 */
public class SerializableTest {

    public static void main(String[] args) {
        //通过反序列化创建的对象
        SeriableSingleton s1 = null;
        //通过单例创建的对象
        SeriableSingleton s2 = SeriableSingleton.getInstance();
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("SeriableSingletion.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SeriableSingletion.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingleton)ois.readObject();

            System.out.println(s1 == s2);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
