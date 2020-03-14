package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 配置类
 * @Author: Ander Lee
 * @Date: 2020-03-14
 * @Version: V1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 随机
        return new RoundRobinRule();
    }
}
