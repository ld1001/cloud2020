package com.atguigu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: 支付启动类
 * @Author: Ander Lee
 * @Date: 2020-03-14
 * @Version: V1.0
 */
@SpringBootApplication
// 该注解用于向zookeeper或consul做为注册中心注册的时候使用
@EnableDiscoveryClient
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
