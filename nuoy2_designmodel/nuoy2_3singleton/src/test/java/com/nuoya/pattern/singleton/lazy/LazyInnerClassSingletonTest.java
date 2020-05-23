package com.nuoya.pattern.singleton.lazy;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingletonTest {
    public static void main(String[] args) throws Exception {

        Class clazz = LazyInnerClassSingleton.class;
        // getConstructor 只返回public方法
        Constructor constructor = clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);// 强吻
        Object o = constructor.newInstance();
        System.out.println(o);
        LazyInnerClassSingleton instance1 = LazyInnerClassSingleton.getInstance();

        System.out.println(instance1);
        LazyInnerClassSingleton instance2 = LazyInnerClassSingleton.getInstance();

        System.out.println(instance2);
    }

}