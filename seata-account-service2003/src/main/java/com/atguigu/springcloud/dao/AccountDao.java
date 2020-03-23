package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020/3/23
 * @Version: V1.0
 */
@Mapper
public interface AccountDao {

    /**
     * 扣余额
     */
    int decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
