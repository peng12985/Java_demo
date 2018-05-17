package com.demo.controller;

import com.demo.annotation.DataType;
import com.demo.annotation.ResponseType;
import com.demo.domain.D;
import com.demo.domain.DR;
import com.demo.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

//访问：http://localhost:8080/swagger-ui.html 查看生成api文档
@RequestMapping("swagger")
@RestController(value = "/test")
public class TestController {

    @ApiOperation(value = "测试api doc 生成-get", notes = "生成api")
    @GetMapping("/user")
    @ResponseBody
    public String getName() {
        System.out.println("getName()");
        return "user1";
    }

    @ApiOperation(value = "wsagger-添加用户", notes = "添加")
    @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    @PostMapping("/")
    @ResponseBody
//    自定义注解
    @DataType(name = "data", type = D.class)
    @ResponseType(name = "data", type = DR.class)
    public User<DR> addUser(@RequestBody User<D> user) {
        System.out.println(user);
        return null;
    }

}