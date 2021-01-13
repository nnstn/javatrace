package com.nuoya.srcode.config;

import com.nuoya.srcode.bean.BeanTime;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(value = "com.hnnd", includeFilters ={
//        @ComponentScan.Filter(type = FilterType.CUSTOM,value = {MyFilterType.class}),
//},useDefaultFilters = false)
@Import({ImportConfig.class,MyImportSelect.class})
public class MainConfig {

    @Bean
//    @Lazy
    @Scope( "singleton" )
    @Conditional(MyCondtional.class)
    public ConfigureClass configureClass(){
        return new ConfigureClass();
    }
    @Bean(initMethod = "init",destroyMethod = "destroyBean")
    public BeanTime beanTime(){
        return new BeanTime();
    }
}