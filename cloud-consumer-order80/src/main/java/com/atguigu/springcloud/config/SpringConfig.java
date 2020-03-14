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
    // 开启负载均衡，使用ribbon自定义负载均衡算法时就开启，如果使用LoadBalance负载均衡器就关闭
    // @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
