package com.nuoya.design.factory;

public class JavaCourse implements ICourse {
    public JavaCourse() {
        System.out.println("this is java constructor");
    }

    @Override
    public void recoder() {
        System.out.println("this is java course");
    }
}
