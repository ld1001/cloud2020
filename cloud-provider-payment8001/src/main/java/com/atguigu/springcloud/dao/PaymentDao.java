package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 支付接口
 * @Author: Ander Lee
 * @Date: 2020-03-13
 * @Version: V1.0
 */
@Mapper
// @Repository,使用这个注解在插入的时候可能会有问题
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
