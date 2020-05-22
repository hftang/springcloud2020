package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: hftang
 * @Date: 2020/4/3 10:47
 * @Description:
 */

@RestController
@Slf4j
public class OrderController {

    private final static String URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/comsumer/payment/consul")
    public String payment() {
        String object = this.restTemplate.getForObject(URL + "/payment/consul", String.class);
        System.out.println(object);
        return object;
    }


}
