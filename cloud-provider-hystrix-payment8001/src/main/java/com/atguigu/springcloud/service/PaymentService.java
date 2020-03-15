package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020-03-15
 * @Version: V1.0
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallback", commandProperties = {
             @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "600")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 500;
        try {
            // 暂停3秒钟
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    /**
     * 熔断方法
     * @param id
     * @return
     */
    public String paymentInfoTimeOutFallback(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " 服务器出错***";
    }
}
