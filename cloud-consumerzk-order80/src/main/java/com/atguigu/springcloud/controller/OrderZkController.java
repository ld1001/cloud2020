package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020-03-14
 * @Version: V1.0
 */
 @RestController
 @RequestMapping("/consumer/payment")
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
     private RestTemplate restTemplate;

     @GetMapping("/zk")
     public String getPaymentInfo() {
         return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
     }

}
