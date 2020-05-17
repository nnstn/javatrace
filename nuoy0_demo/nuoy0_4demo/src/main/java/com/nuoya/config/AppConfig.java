package com.nuoya.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.nuoya")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
