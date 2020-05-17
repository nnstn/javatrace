package com.nuoya.controller;

import com.nuoya.pojo.Role;
import com.nuoya.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @PostMapping("getall")
    public List<Role> getAllRole() {

        return roleService.getAllRole();
    }
    @PostMapping("insert")
    public int insertRole(@RequestBody Map request){
        Role role = new Role();
        role.setRoleName((String) request.get("rolename"));
        return roleService.insertRole(role);
    }
    @PostMapping("update")
    public int updateRole(@RequestBody Map request){
        Role role = new Role();
        role.setRoleName((String) request.get("rolename"));
        return roleService.updateRole(role);
    }
    @PostMapping("delete")
    public int deleteRole(@RequestBody Map request){
        return roleService.deleteRole((Long) request.get("roleid"));
    }
}
