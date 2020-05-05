package com.nuoya.spring.dto;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Arrays;

public class BeanDefinitionReaderExample {
    public static void main(String[] args) {
        // 注册中心
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        // 读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        // 装载构建bean的定义
        reader.loadBeanDefinitions("spring.xml");


        registry.getAliases("helloName");
        registry.getAliases("helloId");
        System.out.println();

        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));

    }
}
