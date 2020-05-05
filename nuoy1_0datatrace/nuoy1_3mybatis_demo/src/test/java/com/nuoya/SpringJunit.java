package com.nuoya;


import com.nuoya.mybatis.config.AppConfig;
import com.nuoya.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SpringJunit {
    @Autowired
    UserService userService;

    @Test
    public void testspring(){
        userService.query(1l);
    }
}
