package com.nuoya.design.factory.simplefactory;

import com.nuoya.design.factory.ICourse;

/**
 * 不符合开闭原则，新增产品的时候需要改工厂方法
 */
public class Simplefactory {

    private Simplefactory() {
    }

    public static ICourse getSourse(Class course) {

        try {
            if (course != null) {
                return (ICourse) course.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
