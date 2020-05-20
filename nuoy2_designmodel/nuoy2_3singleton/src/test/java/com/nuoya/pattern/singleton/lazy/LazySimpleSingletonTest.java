package com.nuoya.pattern.singleton.lazy;

import org.junit.Test;

import static org.junit.Assert.*;

public class LazySimpleSingletonTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExcuteThread());
        Thread t2 = new Thread(new ExcuteThread());
        t1.start();
        t2.start();

        System.out.println("执行结束");
    }
}