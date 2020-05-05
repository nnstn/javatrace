package com.nuoya.design.jdkproxy;

import java.lang.reflect.Proxy;

public class JdkProxyClient {
    public static void main(String[] args) {
        Subject subject = (Subject)Proxy.
                newProxyInstance(MyInvocationHandler.class.getClassLoader(),
                    RealSubject.class.getInterfaces(),
                    new MyInvocationHandler(new RealSubject()));
        subject.helloworld();
    }
}
