package com.nuoya.srcode.controller;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangjn_bj
 * @date : 2020/10/27 8:52
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/one")
    public void test(){

    }
}
