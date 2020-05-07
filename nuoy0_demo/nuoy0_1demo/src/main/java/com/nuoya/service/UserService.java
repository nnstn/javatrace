package com.nuoya.service;

import com.nuoya.mapper.UserMapper;
import com.nuoya.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public List<User> getAll(){
        return userMapper.getAll();
    }

    public int insertUser(User user){
        return userMapper.insert(user);
    }
}
