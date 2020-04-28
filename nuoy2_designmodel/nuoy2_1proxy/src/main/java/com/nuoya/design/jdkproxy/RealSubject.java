package com.nuoya.design.jdkproxy;

public class RealSubject implements Subject{
    @Override
    public void helloworld() {
        System.out.println("helloworld");
    }
}
