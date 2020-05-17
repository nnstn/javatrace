package com.sitech.aicp.config;

import com.sitech.aicp.web.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<LoginFilter> filterRegistrationBean(){
        FilterRegistrationBean<LoginFilter> bean = new FilterRegistrationBean<LoginFilter>();
        bean.setFilter(new LoginFilter());
        bean.addUrlPatterns("/schedule/*");
        bean.addUrlPatterns("/camera/*");
        return bean;
    }
}