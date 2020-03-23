package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Order;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020/3/23
 * @Version: V1.0
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
