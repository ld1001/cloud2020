package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020-03-15
 * @Version: V1.0
 */
@Configuration
public class FeignConfig {

    /**
     * 配置FeignClient日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
