package com.nuoya;

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

    @Test
    public void test3(){
        try {
            String config = "mybatis-config.xml";
            InputStream resource = Resources.getResourceAsStream(config);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectByPrimaryKey(1l);
            System.out.println(user.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
