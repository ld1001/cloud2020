package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 配置类
 * @Author: Ander Lee
 * @Date: 2020-03-13
 * @Version: V1.0
 */
@Configuration
public class SpringConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
