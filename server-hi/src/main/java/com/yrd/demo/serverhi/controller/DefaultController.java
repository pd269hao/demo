package com.yrd.demo.serverhi.controller;

import com.yrd.common.BaseRequest;
import com.yrd.common.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/hello")
    public Person sayHello(@RequestBody BaseRequest request) {
        return Person.builder().name(request.getParam()).age("18").build();
    }
}
