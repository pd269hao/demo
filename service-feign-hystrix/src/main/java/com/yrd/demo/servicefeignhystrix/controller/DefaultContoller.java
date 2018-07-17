package com.yrd.demo.servicefeignhystrix.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IDEA
 * Author:Liuwl
 * Date:2018/7/4
 * Time:15:44
 */
@Api
@RestController
public class DefaultContoller {

    @Autowired
    com.yrd.demo.servicefeignhystrix.service.ServiceHi serviceHi;

    @ApiOperation(value = "默认接口，fsayHi")
    @ApiImplicitParam(name = "name", value = "名字", required = true, dataType = "String")
    @ApiResponses(@ApiResponse(code = 200, response = String.class, message = "SUCCESS"))
    @GetMapping("fhi")
    public String sayHiFeign(String name) {
        return serviceHi.sayHiFromClient(name);
    }
}
