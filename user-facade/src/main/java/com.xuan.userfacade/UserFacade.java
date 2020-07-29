package com.xuan.userfacade;

import com.xuan.common.vo.RespVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author xuan
 * @Date 2020/7/29 10:41
 **/

@FeignClient(name = "user-web", path = "/api")
public interface UserFacade {

    @GetMapping("/findPage")
    RespVo<String> findPage();
}
