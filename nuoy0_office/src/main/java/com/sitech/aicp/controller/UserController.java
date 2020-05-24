package com.sitech.aicp.controller;

import com.sitech.aicp.bean.JsonData;
import com.sitech.aicp.bean.PageQuery;
import com.sitech.aicp.bean.PageResult;
import com.sitech.aicp.pojo.User;
import com.sitech.aicp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("getall")
    public JsonData getAllUser(@RequestBody PageQuery pageQuery) {
        PageResult<User> pageResult = userService.getAllUser(pageQuery);
        return JsonData.success(pageResult);
    }

    @PostMapping("insert")
    public JsonData insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return JsonData.success("添加成功");
    }

    @PostMapping("update")
    public JsonData updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return JsonData.success("更新成功");
    }

    @PostMapping("delete/{id}")
    public JsonData deleteTask(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return JsonData.success("删除成功");
    }
}
