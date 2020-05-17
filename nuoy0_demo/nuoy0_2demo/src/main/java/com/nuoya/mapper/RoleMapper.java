package com.nuoya.mapper;


import com.nuoya.pojo.Role;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {
    @Select("select id,role_name,create_time from role")
    List<Role> getAllRole();
}
