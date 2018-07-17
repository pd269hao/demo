package com.yrd.demo.serviceribbonhystrix.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/4
 * Time:14:27
 */
@Api
@RestController
public class DefaultController {

    @Autowired
    com.yrd.demo.serviceribbonhystrix.service.DefaultService defaultService;

    @ApiOperation(value = "默认接口，sayHi")
    @ApiImplicitParam(name = "name", value = "名字", required = true, dataType = "String")
    @ApiResponses(@ApiResponse(code = 200, response = String.class, message = "SUCCESS"))
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(String name) {
        return defaultService.sayHi(name);
    }
}
