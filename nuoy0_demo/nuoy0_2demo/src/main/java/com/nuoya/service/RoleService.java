package com.nuoya.service;

import com.nuoya.mapper.RoleMapper;
import com.nuoya.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public  class RoleService {

    @Resource
    RoleMapper roleMapper;

    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    public int insertRole(Role role) {
        role.setCreateTime(new Date());
        return roleMapper.insert(role);
    }

    public int updateRole(Role role) {
        role.setCreateTime(new Date());
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    public int deleteRole(Long roleid) {
        return roleMapper.deleteByPrimaryKey(roleid);
    }
}