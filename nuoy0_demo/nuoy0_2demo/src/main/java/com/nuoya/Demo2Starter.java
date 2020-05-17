package com.nuoya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.nuoya.mapper")
public class Demo2Starter {
    public static void main(String[] args) {
        SpringApplication.run(Demo2Starter.class,args);
    }


}
