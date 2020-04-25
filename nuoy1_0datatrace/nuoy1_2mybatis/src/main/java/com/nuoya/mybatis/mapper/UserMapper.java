package com.nuoya.mybatis.mapper;

import com.nuoya.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where id=#{id}")
    public User selectUser(Long id);

    @Select("select id,userName,age,phone,`desc` from user where id=#{id}")
    public User selectUserDetail(Long id);
}


