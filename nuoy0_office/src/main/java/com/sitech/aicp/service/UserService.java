package com.sitech.aicp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sitech.aicp.bean.PageQuery;
import com.sitech.aicp.bean.PageResult;
import com.sitech.aicp.mapper.UserMapper;
import com.sitech.aicp.pojo.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    /**
     * 分页查询
     */
    public PageResult<User> getAllUser(PageQuery pageQuery){
        // 分页
        PageHelper.startPage(pageQuery.getPageNo(), pageQuery.getPageSize(),pageQuery.getSortBy()+(pageQuery.getDesc() ? " DESC" : " ASC"));
        // 查询
        List<User> Tasks = userMapper.getAllUser();

        PageInfo<User> info = new PageInfo<>(Tasks);
        // 解析分页结果
        return new PageResult<User>(info.getTotal(), Tasks);
    }
    public int insertUser(User user){
        user.setCreateTime(new Date());
        user.setLastUpdateTime(new Date());
        return userMapper.insert(user);
    }

    public int updateUser(User user){
        user.setLastUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(user);
    }
    public int deleteUser(Long userId){
        return userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 根据用户名查找用户
     */
    public List<User> getUserByUserCode(String userCode){
        return userMapper.getUserByUserCode(userCode);
    }

    /**
     * 根据条件查找用户
     */
    public List<User> getUserByCondition(User user){

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(null!=user.getUserName()){
            criteria.andEqualTo("userName", user.getUserName());
        }
        if(null!=user.getUserName()){
            criteria.andEqualTo("phone", user.getUserName());
        }
        if(null!=user.getUserName()){
            criteria.andEqualTo("email", user.getUserName());
        }
        return userMapper.selectByExample(example);
    }
}
