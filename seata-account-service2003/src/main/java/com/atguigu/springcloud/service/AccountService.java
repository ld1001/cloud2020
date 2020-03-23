package com.atguigu.springcloud.service;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020/3/23
 * @Version: V1.0
 */
public interface AccountService {

    /**
     * 扣余额
     */
    int decrease(Long userId, BigDecimal money);
}
