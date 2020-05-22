package springcloud.controller;

import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import javax.annotation.Resource;

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

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/getPort")
    public String getPort() {
        return this.port;
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

        log.info("端口号是：{}", port);
        Payment payment = this.paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询失败");
        }
    }


}
