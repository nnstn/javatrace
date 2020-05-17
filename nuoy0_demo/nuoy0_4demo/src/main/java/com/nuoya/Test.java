package com.nuoya;

import com.nuoya.config.AppConfig;
import com.nuoya.dao.AclDao;
import com.nuoya.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AclDao dao = context.getBean(AclDao.class);
        System.out.println(dao);
        dao.query("annotation");
        System.out.println("================");
        UserDao userDao = context.getBean(UserDao.class);
        userDao.query();
    }
}
