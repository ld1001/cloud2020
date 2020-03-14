package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description: 负载均衡器接口
 * @Author: Ander Lee
 * @Date: 2020-03-14
 * @Version: V1.0
 */
public interface LoadBalance {

    /**
     * 返回具体微服务的所有实例
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
