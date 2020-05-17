package com.nuoya.dao;

import com.nuoya.annotation.Demo;
import org.springframework.stereotype.Component;

@Component
public class AclDao {

    @Demo
    public void query(String parameter){
        System.out.println("hello query:"+parameter);
    }
}
