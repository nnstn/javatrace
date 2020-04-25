package com.nnstn.jdbc;

import org.junit.Test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class GoddessDaoTest {

    GoddessDao goddessDao = new GoddessDao();
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    @Test
    public void addGoddess() throws Exception {
        Goddess goddess = new Goddess();
        goddess.setAge(18);
        goddess.setSex(1);
        goddess.setEmail("wangjn1130@163.com");
        goddess.setIsDel(1);


        goddess.setBirthday(dateFormat.parse("19870417"));
        goddessDao.addGoddess(goddess);
    }

    @Test
    public void updateGoddess() throws Exception {

        Goddess goddess = new Goddess();
        goddess.setAge(18);
        goddess.setSex(1);
        goddess.setEmail("wangjn1130@163.com");
        goddess.setIsDel(1);
        goddess.setUserName("南哥");
        goddess.setBirthday(dateFormat.parse("19870417"));
        goddessDao.updateGoddess(goddess);
    }

    @Test
    public void delGoddess() throws SQLException {
        goddessDao.delGoddess(2);
    }

    @Test
    public void query() throws SQLException {
        List<Goddess> list = goddessDao.query();
        System.out.println(list);
    }

    @Test
    public void get() throws SQLException {
        Goddess goddess = goddessDao.get(1);
        System.out.println(goddess);

    }
}