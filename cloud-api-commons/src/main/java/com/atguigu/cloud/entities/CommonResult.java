package com.atguigu.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: hftang
 * @Date: 2020/4/1 15:41
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {

    private Integer code;//状态吗

    private String msg;//提示语

    private T data;//返回的对象


    //定义一个两个参数的构造器


    public CommonResult(Integer code, String msg) {
        this(code, msg, null);
    }
}
