package com.nnstn.jdbc;

import lombok.Data;

import java.util.Date;

@Data
public class Goddess {

    private Integer id;
    private String userName;
    private Integer sex;
    private Integer age;
    private Date birthday; //注意用的是java.util.Date
    private String email;
    private String mobile;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;

    private Integer isDel;
}