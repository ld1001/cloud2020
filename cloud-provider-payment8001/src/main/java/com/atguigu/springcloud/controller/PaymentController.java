package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 支付控制类
 * @Author: Ander Lee
 * @Date: 2020-03-13
 * @Version: V1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    // 一定要使用@RequestBody，要不针绑定不上数据
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****添加数据库成功，返回的id的是：" + result);
        log.info(payment.getSerial());
        if (result > 0) {
            return new CommonResult(200, "添加成功", result);
        } else {
            return new CommonResult(404, "添加失败", null);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(200, "查询失败", null);
        }
    }

}
