package com.nuoya.mybatis.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
//注册包中递归搜索映射器
@ComponentScan("com.nuoya.mybatis")//注册Bean
@MapperScan("com.nuoya.mybatis.mapper")//注解 与XML<mybatis:scan base-package="org.mybatis.spring.sample.mapper" />
public class MybatisConfiguration {
    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource ) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mappers/*"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javatrace?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        return dataSource;
    }
}
