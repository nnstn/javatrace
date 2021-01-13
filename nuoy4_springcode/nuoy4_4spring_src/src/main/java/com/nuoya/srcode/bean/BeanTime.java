package com.nuoya.srcode.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author : wangjn_bj
 * @date : 2020/10/30 8:50
 */
public class BeanTime implements InitializingBean , DisposableBean, BeanPostProcessor {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("======================");
        System.out.println("第二步：InitializingBean 创建完成 bean 执行");
        System.out.println("======================");
    }
    public void init(){
        System.out.println("======================");
        System.out.println("第四步：创建bean");
        System.out.println("======================");
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======================");
        System.out.println("第一步：postProcessBeforeInitialization创建:"+beanName);
        System.out.println("======================");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======================");
        System.out.println("第三步：postProcessAfterInitialization:"+beanName);
        System.out.println("======================");
        return bean;
    }

    @PostConstruct
    public void PostConstruct(){
        System.out.println("======================");
        System.out.println("第三步：PostConstruct 创建bean");
        System.out.println("======================");

    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("======================");
        System.out.println("第七步：PreDestroy销毁bean");
        System.out.println("======================");
    }
    public void destroyBean(){
        System.out.println("======================");
        System.out.println("第九步：销毁bean");
        System.out.println("======================");
    }

    @Override
    public void destroy(){
        System.out.println("======================");
        System.out.println("第八步：DisposableBean 销毁bean");
        System.out.println("======================");
    }

}
