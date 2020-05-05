package com.nuoya.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Transactional
    public void addAccount(String name, int initMenoy) {
        String accountid = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        jdbcTemplate.update("insert INTO account (accountName,user,money) VALUES (?,?,?)", accountid, name, initMenoy);
        // 人为报错
        int i = 1 / 0;
    }
}
