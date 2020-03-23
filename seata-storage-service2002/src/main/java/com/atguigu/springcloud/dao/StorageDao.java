package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020/3/23
 * @Version: V1.0
 */
@Mapper
public interface StorageDao {

    /**
     * 减库存
     */
    int decrease (@Param("productId") Long productId, @Param("count") Integer count);
}
