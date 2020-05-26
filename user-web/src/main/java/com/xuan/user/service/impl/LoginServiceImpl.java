package com.xuan.user.service.impl;

import com.xuan.common.vo.LoginCacheVo;
import com.xuan.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public LoginCacheVo login() {
        return new LoginCacheVo();
    }
}
