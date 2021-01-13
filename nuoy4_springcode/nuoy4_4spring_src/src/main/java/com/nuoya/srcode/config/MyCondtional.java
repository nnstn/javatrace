package com.nuoya.srcode.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondtional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //context是条件上下问   metadata 是注解元信息
        BeanDefinitionRegistry registry =  context.getRegistry();
        String[] definitionNames = registry.getBeanDefinitionNames();
        for (String name: definitionNames) {
            System.out.println("beandefinitionName:" + name );
            if(name.equals("srcCodeStarter")){   //bean定义中包含personService 才注册
                return true;
            }
        }
        return false;
    }
}