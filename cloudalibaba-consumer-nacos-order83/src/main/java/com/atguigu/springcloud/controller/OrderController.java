package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: hftang
 * @Date: 2020/4/9 17:40
 * @Description:
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String Url;


    @GetMapping("/comsumer/payment/nacos/{id}")
    public String  paymentInfo(@PathVariable("id") Long id){

        return this.restTemplate.getForObject(Url+"/payment/nacos/"+id,String.class);
    }


}
