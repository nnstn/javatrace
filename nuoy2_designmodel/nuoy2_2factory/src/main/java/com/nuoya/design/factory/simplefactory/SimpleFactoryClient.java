package com.nuoya.design.factory.simplefactory;

import com.nuoya.design.factory.ICourse;
import com.nuoya.design.factory.JavaCourse;

public class SimpleFactoryClient {
    public static void main(String[] args) {
        ICourse sourse = Simplefactory.getSourse(JavaCourse.class);
        sourse.recoder();

    }
}
