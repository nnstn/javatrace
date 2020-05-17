package com.sitech.aicp.service;

import com.sitech.aicp.mapper.UserMapper;
import com.sitech.aicp.pojo.User;
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
