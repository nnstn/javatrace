package com.nuoya.pattern.singleton.lazy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 使用序列化来攻击单例
 */
public class SerializeLazyInnerClassSingletonTest {
    public static void main(String[] args) throws Exception {


        LazyInnerClassSingleton instance1 = null;
        LazyInnerClassSingleton instance2 = LazyInnerClassSingleton.getInstance();

        System.out.println(instance2);


        FileOutputStream fos = new FileOutputStream("SerializeObject");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance2);

        FileInputStream fis = new FileInputStream("SerializeObject");
        ObjectInputStream ois = new ObjectInputStream(fis);
        instance1 = (LazyInnerClassSingleton) ois.readObject();

        System.out.println(instance1);


    }

}