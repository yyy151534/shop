package com.xuan.userfacade;


import com.xuan.common.vo.RespVo;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeFallBack implements UserFacade{
    @Override
    public RespVo<String> findPage() {
        return RespVo.onSuc("已经进入熔断。。。");
    }
}
