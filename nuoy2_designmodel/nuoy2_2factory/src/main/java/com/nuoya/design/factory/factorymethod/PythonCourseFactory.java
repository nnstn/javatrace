package com.nuoya.design.factory.factorymethod;

import com.nuoya.design.factory.ICourse;
import com.nuoya.design.factory.PythonCourse;

public class PythonCourseFactory implements IFactory{

    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
