package com.nuoya.mybatis;

import com.nuoya.mybatis.mapper.UserMapper;
import com.nuoya.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    // 此方法 com.nuoya.mybatis.mapper.UserMapper 类不存在也可以
    @Test
    public void test1(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            User user = session.selectOne("com.nuoya.mybatis.mapper.UserMapper.selectUser", 1L);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 此方法 UserMapper.xml 类不存在也可以
    @Test
    public void test2(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUser(1l);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
