package com.sitech.aicp.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long leader;

    private String userCode;

    private String userName;

    private String password;

    private String email;

    private String phone;

    private String salt;

    private Date createTime;

    private Date lastUpdateTime;

    private String opeationIp;
}
