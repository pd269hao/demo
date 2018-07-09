package com.yrd.demo.servicefeignhystrix.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/4
 * Time:14:50
 */
@FeignClient(value = "server-hi",fallback = ServiceHiHystrix.class)
public interface ServiceHi {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    String sayHiFromClient(String name);

}
