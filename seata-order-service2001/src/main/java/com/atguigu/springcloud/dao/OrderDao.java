package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020/3/23
 * @Version: V1.0
 */
@Mapper
public interface OrderDao {

    /**
     * 创建订单
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 修改状态
     * @param userId
     * @param status
     * @return
     */
    // 这里能过@Param注解进行参数绑定，OrderMapper中写sql语句的时候就不用写paramerType属性了
    int update(@Param("userId") Long userId, @Param("status") Integer status);

}
