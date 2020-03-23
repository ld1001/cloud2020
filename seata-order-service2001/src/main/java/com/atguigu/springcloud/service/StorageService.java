package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: Ander Lee
 * @Date: 2020/3/23
 * @Version: V1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 减库存
     */
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("ProductId") Long productId, @RequestParam("count") Integer count);

}
