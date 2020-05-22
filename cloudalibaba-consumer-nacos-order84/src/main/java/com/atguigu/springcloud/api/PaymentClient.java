package com.atguigu.springcloud.api;

import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import com.atguigu.springcloud.fallback.MyFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: hftang
 * @Date: 2020/4/15 15:54
 * @Description:
 */

@FeignClient(value = "nacos-payment-provider", fallback = MyFallback.class)
public interface PaymentClient {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
