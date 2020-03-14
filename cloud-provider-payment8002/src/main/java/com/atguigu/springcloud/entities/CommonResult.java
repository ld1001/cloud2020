package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

/**
 * @Description: 结果实体类
 * @Author: Ander Lee
 * @Date: 2020-03-13
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
