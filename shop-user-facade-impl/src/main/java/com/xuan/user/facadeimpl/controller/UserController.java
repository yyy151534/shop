package com.xuan.user.facadeimpl.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("user类")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("添加user")
    @PostMapping("/addUser")
    public void addUser(){

    }
}
