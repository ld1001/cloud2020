package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:  Eureka注册中心
 * @Author: Ander Lee
 * @Date: 2020-03-13
 * @Version: V1.0
 */
 @SpringBootApplication
 @EnableEurekaServer
public class EurekaMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
