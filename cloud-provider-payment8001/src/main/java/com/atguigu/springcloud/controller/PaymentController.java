package com.atguigu.springcloud.controller;

import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: hftang
 * @Date: 2020/4/1 16:16
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;


    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/getPort")
    public String getPort() {
        return this.port;
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = this.discoveryClient.getServices();
        for (String service : services) {
            System.out.println("获取到的服务信息：" + service);
        }

        List<ServiceInstance> instances = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("获取到的实例：" + instance);
        }

        return discoveryClient;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {


        int count = this.paymentService.create(payment);


        if (count > 0) {
            return new CommonResult(200, "插入成功", count);
        } else {
            return new CommonResult(444, "插入失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("查询的端口号：{}", port);
        Payment payment = this.paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询失败");
        }
    }


}
