package com.nuoya.controller;

import com.nuoya.pojo.Acl;
import com.nuoya.service.AclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/acl")
public class AclController {
    @Autowired
    AclService aclService;

    @RequestMapping("getAll")
    public ResponseEntity<Acl> getAll() {
        return new ResponseEntity(aclService.getAllAcl(), HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity<Acl> insertAcl(@RequestBody Map request) {
        String aclName = (String) request.get("acl_name");
        Acl acl = new Acl();
        acl.setAclName(aclName);
        return new ResponseEntity(aclService.insertAcl(acl), HttpStatus.OK);
    }
}
