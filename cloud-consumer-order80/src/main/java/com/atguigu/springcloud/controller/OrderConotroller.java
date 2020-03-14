package com.atguigu.springcloud.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;

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

    @GetMapping("/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity != null) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "查询失败");
        }
    }

    /**
     * 使用负载均衡器来负载均衡
     */
    @GetMapping("lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (CollectionUtil.isEmpty(instances)) {
            return null;
        }
        // 手写负载均衡器的核心就是通过编写负载均衡算法来获取到某次具体要执行的instance
        ServiceInstance serviceInstance = loadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(PAYMENT_URL + "/payment/lb", String.class);
    }
}
