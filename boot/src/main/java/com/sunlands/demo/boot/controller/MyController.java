package com.sunlands.demo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2019/7/9
 **/
@RestController
@RequestMapping("/boot")
public class MyController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public String hello(String name) {
        if (redisTemplate != null) {
            String cache = redisTemplate.opsForValue().get("1");
            if (StringUtils.isEmpty(cache)) {
                redisTemplate.opsForValue().set("1", "world");
            }
            return "hello " + name + " " + cache;
        } else {
            return "redis null";
        }
    }
}
