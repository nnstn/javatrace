package com.nuoya.pattern.singleton.lazy;

public class LazySimpleSingleton {
    private static LazySimpleSingleton instance;

    private LazySimpleSingleton() {
    }

    public static synchronized LazySimpleSingleton getInstance(){
        if(null==instance){
            instance = new LazySimpleSingleton();
        }
        return instance;
    }
}
