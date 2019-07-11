package com.yrd.demo.servicefeign.service;

import com.yrd.common.BaseRequest;
import com.yrd.common.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/4
 * Time:14:50
 */
@FeignClient(value = "server-hi")
public interface ServiceHi {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    String sayHiFromClient(String name);

    @PostMapping(value = "hello")
    Person sayHelloFromClient(BaseRequest name);

}
