package com.yrd.demo.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/4
 * Time:14:26
 */
@Service
public class DefaultService {
    @Autowired
    RestTemplate restTemplate;

    public String sayHi(String name) {
        return restTemplate.getForObject("http://SERVER-HI/hi?name=" + name, String.class);
    }
}
