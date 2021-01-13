package com.nuoya.srcode.config;

import com.nuoya.srcode.bean.ImportPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ImportConfig {

    @Bean(name = "importPojo")
    public ImportPojo importPojo(){
        return new ImportPojo();
    }
}