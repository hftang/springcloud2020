package com.atguigu.springcloud.myhander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.entities.CommonResult;

/**
 * @Auther: hftang
 * @Date: 2020/4/14 17:51
 * @Description:
 */
public class MyHandler {

    public static CommonResult handlerMethod01(BlockException e){
        return new CommonResult(444,"第一种兜底方法");
    }

    public static CommonResult handlerMethod02(BlockException e){
        return new CommonResult(444,"第er种兜底方法");
    }
}
