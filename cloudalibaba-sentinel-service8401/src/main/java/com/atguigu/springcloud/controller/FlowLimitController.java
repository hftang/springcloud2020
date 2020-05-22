package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.entities.CommonResult;
import com.atguigu.springcloud.myhander.MyHandler;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: hftang
 * @Date: 2020/4/13 10:34
 * @Description:
 */

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        log.info(Thread.currentThread().getName() + "\t" + "testB");

//        try {
////            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return "------testB";
    }


    @GetMapping("/testD")
    public String testD() {
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");

        log.info("异常比例：：：：");

        int i = 10 / 0;

        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");

        log.info("异常数：：：：");

        int i = 10 / 0;
        return "------testE";
    }

    //热词限流

    @GetMapping(value = "/hotkey")
    @SentinelResource(value = "hotkey", blockHandler = "sentinelHandler")
    public String keyHotTest(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {


        return "------hotkey" + p1 + ":::::" + p2;
    }

    public String sentinelHandler(String p1, String p2, BlockException e) {

        return "hotkey 出错了----" + e;
    }


    @GetMapping(value = "/rateLimit/customerBlockHander")
    @SentinelResource(value = "ratelimit", blockHandlerClass = MyHandler.class, blockHandler = "handlerMethod01")
    public CommonResult rateLimit() {

        return new CommonResult(200, "成功");
    }

}
