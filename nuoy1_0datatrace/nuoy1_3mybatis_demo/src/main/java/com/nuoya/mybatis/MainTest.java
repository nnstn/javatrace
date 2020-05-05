package com.nuoya.mybatis;

import com.nuoya.mybatis.config.AppConfig;
import com.nuoya.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String args[]){
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService us = acc.getBean(UserService.class);
        us.query(1L);
    }
}