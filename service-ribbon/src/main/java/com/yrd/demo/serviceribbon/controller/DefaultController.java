package com.yrd.demo.serviceribbon.controller;

import com.yrd.demo.serviceribbon.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/4
 * Time:14:27
 */
@RestController
public class DefaultController {

    @Autowired
    DefaultService defaultService;

    @RequestMapping("/hi")
    public String sayHi(String name) {
        return defaultService.sayHi(name);
    }
}
