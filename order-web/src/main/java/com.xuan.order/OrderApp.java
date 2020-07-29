package com.xuan.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author xuan
 * @Date 2020/7/29 10:37
 **/

@ComponentScan("com.xuan")
@EnableFeignClients(basePackages = {"com.xuan"})
@SpringCloudApplication
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
