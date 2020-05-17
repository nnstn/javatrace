package com.nuoya;

import com.nuoya.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.start();
//        AclDao dao = context.getBean(AclDao.class);
//        System.out.println(dao);
//        dao.query("annotation");
//        System.out.println("================");
//        UserDao userDao = context.getBean(UserDao.class);
//        userDao.query();
    }
}
