package com.nuoya.design.factory;

public class PythonCourse implements ICourse {

    public PythonCourse() {
        System.out.println("this is python constructor");
    }

    @Override
    public void recoder() {
        System.out.println("this is python course");
    }
}
