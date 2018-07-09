package com.yrd.demo.servicefeignhystrix.service;

import org.springframework.stereotype.Component;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/6
 * Time:11:26
 */
@Component
public class ServiceHiHystrix implements ServiceHi {
    @Override
    public String sayHiFromClient(String name) {
        return "sorry," + name + ",there is a error";
    }
}
