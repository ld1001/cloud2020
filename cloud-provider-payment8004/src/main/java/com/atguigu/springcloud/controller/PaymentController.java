package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description: 控制类
 * @Author: Ander Lee
 * @Date: 2020-03-14
 * @Version: V1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String paymentZk() {
        return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
