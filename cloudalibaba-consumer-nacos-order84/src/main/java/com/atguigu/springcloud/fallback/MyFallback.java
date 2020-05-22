package com.atguigu.springcloud.fallback;

import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import com.atguigu.springcloud.api.PaymentClient;
import org.springframework.stereotype.Component;

/**
 * @Auther: hftang
 * @Date: 2020/4/15 15:56
 * @Description:
 */

@Component
public class MyFallback implements PaymentClient {


    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
       return new CommonResult<>(44444, "触发了兜底的异常");
    }
}
