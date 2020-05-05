package com.nuoya.mybatis.service;

import com.nuoya.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
//spring注解中service与component意思差不多，区别在于component是中立注解，而service是业务逻辑层的注解
//@Component
@Service
public class UserService {
 
    @Autowired
    UserMapper userMapper;
 
    public void query(Long uid){
        System.out.println(userMapper.selectByPrimaryKey(uid).toString());
    }
}