package com.yrd.demo.serverhi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/4
 * Time:11:37
 */
@RestController

public class DefaultController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String sayHi(String name) {
        return "hi " + name + ", from server " + port;
    }
}
