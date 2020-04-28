package com.nuoya.design.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    // 这个是我们要代理的真实对象
    private Object subject;
    // 构造方法,给我们要代理的真实对象赋予初值
    public MyInvocationHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object invoke = method.invoke(subject,args);
        System.out.println("after");

        return invoke;
    }
}
