package com.nuoya.design.factory.factorymethod;

import com.nuoya.design.factory.ICourse;
import com.nuoya.design.factory.JavaCourse;

public class JavaCourseFactory implements IFactory{

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
