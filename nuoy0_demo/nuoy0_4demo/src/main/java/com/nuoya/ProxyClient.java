package com.nuoya;

import com.nuoya.dao.UserDao;
import com.nuoya.dao.UserDaoImpl;
import com.nuoya.handler.MyInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyClient {
    public static void main(String[] args) {
        UserDao userDao = (UserDao) Proxy.newProxyInstance(ProxyClient.class.getClassLoader(), UserDaoImpl.class.getInterfaces(), new MyInvocationHandler(new UserDaoImpl()));
        userDao.query();
    }
}
