package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description: 统一处理降级方法
 * @Author: Ander Lee
 * @Date: 2020-03-15
 * @Version: V1.0
 */
// 一定不要忘记添加@Component注解
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back--paymentInfo_TimeOut";
    }
}
