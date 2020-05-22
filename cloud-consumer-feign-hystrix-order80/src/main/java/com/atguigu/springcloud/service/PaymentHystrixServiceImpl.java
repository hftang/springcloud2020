package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Auther: hftang
 * @Date: 2020/4/5 12:44
 * @Description:
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK_lllllkklkk";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut______kkkkkkkkk";
    }
}
