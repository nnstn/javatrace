package com.nuoya.design.factory.factorymethod;

import com.nuoya.design.factory.ICourse;

/**
 * 工厂方法模式:只需要关注产品所对应的工厂即可。具体配置由客户端实现
 */
public class FacatoryMethodClient {
    public static void main(String[] args) {
        IFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.recoder();
    }
}
