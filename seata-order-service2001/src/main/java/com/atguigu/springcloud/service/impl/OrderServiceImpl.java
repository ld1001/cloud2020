package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020/3/23
 * @Version: V1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {

        // 1. 创建订单
        log.info("=====>>>>> 开始创建订单");
        orderDao.create(order);

        // 2. 减库存
        log.info("=====>>>>> 开始减库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("=====>>>>> 减库存结束");

        // 3. 扣余额
        log.info("=====>>>>> 开始扣余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("=====>>>>> 扣余额结束");

        // 4. 改订单状态
        log.info("=====>>>>> 修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("=====>>>>> 创建订单结束");
    }
}
