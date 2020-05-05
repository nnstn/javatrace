package com.nuoya.spring.dto;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Arrays;

public class BeanFactoryExample {
    public static void main(String[] args) {
        // 注册中心
        BeanDefinitionRegistry registry = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        // 资源读取器
        DefaultResourceLoader loader = new DefaultResourceLoader();

        Resource resource = loader.getResource("spring.xml");
        // 装载构建bean的定义
        reader.loadBeanDefinitions(resource);


        registry.getAliases("helloName");
        registry.getAliases("helloId");
        System.out.println();

        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));

    }
}
