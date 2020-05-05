package com.nuoya.mybatis.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;

    private String username;

    private Integer age;

    private Long phone;

    private String desc;
}