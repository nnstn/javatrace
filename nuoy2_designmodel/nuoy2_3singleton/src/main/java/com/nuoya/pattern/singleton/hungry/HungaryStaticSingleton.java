package com.nuoya.pattern.singleton.hungry;

public class HungaryStaticSingleton {

    private static final HungaryStaticSingleton instance;

    static {
        instance = new HungaryStaticSingleton();
    }
    private HungaryStaticSingleton() {
    }

    public static HungaryStaticSingleton getInstance(){
        return instance;
    }
}
