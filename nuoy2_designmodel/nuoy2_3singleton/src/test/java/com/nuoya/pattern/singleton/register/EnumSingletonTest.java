package com.nuoya.pattern.singleton.register;

import java.io.*;
import java.lang.reflect.Constructor;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance1 = EnumSingleton.getInstance();
        EnumSingleton instance2 = EnumSingleton.getInstance();
        instance1.setData(new Object());
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance2 == instance1);
        System.out.println(instance1.getData());
        System.out.println(instance2.getData());
        System.out.println("================================");
        System.out.println("通过反射操作 start");
        System.out.println("================================");
        // 无法实例化枚举类型
        // EnumSingleton enumSingleton = new EnumSingleton();
        try {
            // 从jdk层面就位枚举不被序列化和反序列化破坏来保驾护航
            Constructor c = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
            c.setAccessible(true);
            Object instance3 = c.newInstance();
            System.out.println(instance3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("================================");
        System.out.println("通过反射操作 end");
        System.out.println("================================");

        System.out.println("================================");
        System.out.println("通过序列化也破坏不了单例");
        System.out.println("================================");
        try {

            FileOutputStream fos = new FileOutputStream("SerializeObject");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance1);

            FileInputStream fis = new FileInputStream("SerializeObject");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EnumSingleton instance4 = (EnumSingleton) ois.readObject();

            System.out.println(instance4);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}