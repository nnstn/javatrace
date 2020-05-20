package com.nuoya.pattern.singleton.lazy;

public class ExcuteThread implements Runnable {

    @Override
    public void run() {
        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
        System.out.println(singleton);
    }
}
