package com.atguigu.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: hftang
 * @Date: 2020/4/1 17:36
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 把restTemplate注入到 springIOC中
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
