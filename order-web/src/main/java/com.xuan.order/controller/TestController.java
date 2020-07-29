package com.xuan.order.controller;

import com.xuan.common.enums.ErrorCodeEnum;
import com.xuan.common.vo.RespVo;
import com.xuan.userfacade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author xuan
 * @Date 2020/7/29 11:13
 **/

@RestController
public class TestController {

    @Autowired
    private UserFacade userFacade;

    /**
     * @Author xuan
     * @Description postman調用user的 http://localhost:8000/actuator/service-registry 入參 {"status":"DOWN或者UP"}
     *              調用完后下次心跳檢測時把下綫狀態同步，後續不會調用該台user服務
     **/
    @RequestMapping("/test")
    public void test(){
        RespVo respVo = userFacade.findPage();
        if(respVo.code == ErrorCodeEnum.SUCCESS.getCode()){
            System.out.println("respVo == " + respVo.data);
        }else{
            System.out.println("respVo --------------");
        }
    }
}
