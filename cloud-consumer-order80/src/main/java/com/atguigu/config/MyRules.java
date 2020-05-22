package com.atguigu.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: hftang
 * @Date: 2020/4/3 16:23
 * @Description:
 */

@Configuration
public class MyRules {
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
