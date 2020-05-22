package com.atguigu.springcloud.controller;

        import com.atguigu.cloud.entities.CommonResult;
        import com.atguigu.cloud.entities.Payment;
        import com.atguigu.springcloud.service.PaymentFeignService;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

        import javax.annotation.Resource;

/**
 * @Auther: hftang
 * @Date: 2020/4/3 19:00
 * @Description:
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult paymentById = paymentFeignService.getPaymentById(id);
        return paymentById;
    }
}
