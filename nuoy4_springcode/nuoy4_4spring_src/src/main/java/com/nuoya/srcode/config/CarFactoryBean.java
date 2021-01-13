package com.nuoya.srcode.config;

import com.nuoya.srcode.bean.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
    /**
     * 实际注册到容器的bean
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}