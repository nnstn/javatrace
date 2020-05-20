package com.nuoya.pattern.singleton.hungry;

public class HungarySingleton {
    private static final HungarySingleton instance = new HungarySingleton();
    private HungarySingleton() {
    }

    public static HungarySingleton getInstance(){
        return instance;
    }
}
