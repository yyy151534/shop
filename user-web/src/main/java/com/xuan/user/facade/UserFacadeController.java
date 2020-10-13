package com.xuan.user.facade;

import com.xuan.common.vo.RespVo;
import com.xuan.userfacade.UserFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Thread.sleep;

/**
 * @Description
 * @Author xuan
 * @Date 2020/7/29 11:07
 **/

@RequestMapping("/api")
@RestController
public class UserFacadeController implements UserFacade {

    @Override
    @GetMapping("/findPage")
    public RespVo<String> findPage() {
//        try {
//            sleep(10000);
//            System.out.println("服务超时");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return RespVo.onSuc("嘿， man");
    }
}
