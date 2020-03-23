package com.atguigu.springcloud.service;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020/3/23
 * @Version: V1.0
 */
public interface StorageService {

    /**
     * 减库存
     */
    int decrease(Long productId, Integer count);
}
