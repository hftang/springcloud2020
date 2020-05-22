package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: hftang
 * @Date: 2020/4/9 17:04
 * @Description:
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPort(@PathVariable("id") Integer id) {

        return "返回参数值是：id:" + id + "port：" + port;

    }
}
