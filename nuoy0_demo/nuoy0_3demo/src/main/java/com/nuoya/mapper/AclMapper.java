package com.nuoya.mapper;

import com.nuoya.pojo.Acl;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AclMapper extends Mapper<Acl> {
    @Select("select * from acl")
    List<Acl> getAllList();
}
