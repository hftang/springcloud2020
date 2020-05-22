package com.atguigu.springcloud.dao;

import com.atguigu.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: hftang
 * @Date: 2020/4/1 15:48
 * @Description:
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
