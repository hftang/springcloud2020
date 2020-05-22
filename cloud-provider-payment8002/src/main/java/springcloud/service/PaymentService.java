package springcloud.service;

import com.atguigu.cloud.entities.Payment;

/**
 * @Auther: hftang
 * @Date: 2020/4/1 16:10
 * @Description:
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
