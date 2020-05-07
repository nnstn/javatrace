package com.nuoya.controller;

import com.nuoya.pojo.User;
import com.nuoya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getall")
    public List<User> getall() {
        return userService.getAll();
    }

    @PutMapping("insert")
    public String insertUser(@RequestBody Map map) {
        User user = new User();
        user.setUserName((String) map.get("name"));
        userService.insertUser(user);
        return  "添加成功";
    }
}
