package com.nuoya.mapper;

import com.nuoya.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    @Select("select id,user_name from user")
    List<User> getAll();
}
