package com.yrd.demo.servicefeign.controller;

import com.yrd.demo.servicefeign.service.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/4
 * Time:15:44
 */
@RestController
public class DefaultContoller {

    @Autowired
    ServiceHi serviceHi;

    @RequestMapping("fhi")
    public String sayHiFeign(String name) {
        return serviceHi.sayHiFromClient(name);
    }
}
