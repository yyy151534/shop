package com.xuan.user.controller;

import com.xuan.common.vo.RespVo;
import com.xuan.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public RespVo login(){
        return RespVo.onSuc(loginService.login());
    }
}
