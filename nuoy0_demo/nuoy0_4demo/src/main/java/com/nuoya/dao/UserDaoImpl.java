package com.nuoya.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public void query() {
        System.out.println("query user");
    }
}
