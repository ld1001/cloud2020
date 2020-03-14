package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderFeignClientController
 * @description:
 * @author: XZQ
 * @create: 2020/3/8 15:28
 **/
@RestController
@RequestMapping("/consumer")
public class OrderFeignClientController {

    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }

}
