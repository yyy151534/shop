package com.xuan.user.facade;

import com.xuan.common.vo.RespVo;
import com.xuan.userfacade.UserFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author xuan
 * @Date 2020/7/29 11:07
 **/

@RequestMapping("/api")
@RestController
public class UserFacadeController implements UserFacade {

    @Override
    public RespVo<String> findPage() {
        return RespVo.onSuc("嘿， man");
    }
}
