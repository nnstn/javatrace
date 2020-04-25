package com.nuoya.mybatis.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private int age;
    private Long phone;
    private String desc;

}