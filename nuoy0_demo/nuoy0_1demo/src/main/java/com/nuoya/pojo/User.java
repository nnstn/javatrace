package com.nuoya.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
}
