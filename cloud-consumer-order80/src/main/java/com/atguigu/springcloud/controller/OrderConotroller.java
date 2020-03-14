package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description: 订单控制类
 * @Author: Ander Lee
 * @Date: 2020-03-13
 * @Version: V1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
@EnableEurekaClient
public class OrderConotroller {

    /**
     * 调用payment服务的url
     */
//    public static final String PAYMENT_URL = "http://localhost:8001";
    // 微服务是以服务名进行交互的
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create")
    // 这是不能添加@RequestBody
    public CommonResult<Payment> create(Payment payment) {
        // 注意两个方法区分：return restTemplate.postForEntity(PAYMENT_URL + "/create?payment=", payment, CommonResult.class);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create?serial=", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
