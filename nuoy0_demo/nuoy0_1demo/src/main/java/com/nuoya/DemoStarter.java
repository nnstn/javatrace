package com.nuoya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.nuoya.mapper")
public class DemoStarter {
    public static void main(String[] args) {
        SpringApplication.run(DemoStarter.class,args);
    }
}
