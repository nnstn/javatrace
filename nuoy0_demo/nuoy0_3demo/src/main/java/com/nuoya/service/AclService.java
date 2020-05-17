package com.nuoya.service;

import com.nuoya.mapper.AclMapper;
import com.nuoya.pojo.Acl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AclService {
    @Resource
    AclMapper aclMapper;

    public List<Acl> getAllAcl(){
        return aclMapper.getAllList();
    }

    public int insertAcl(Acl acl){
        acl.setCreateDate(new Date());
        return aclMapper.insert(acl);
    }
}
