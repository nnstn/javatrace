package com.nuoya.srcode.config;

import com.nuoya.srcode.bean.BeanDefinitionPojo;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = new RootBeanDefinition(BeanDefinitionPojo.class); //构建beanDefinition
        registry.registerBeanDefinition("beanDefinitionPojo",beanDefinition); //向容器中注册bean
    }
}