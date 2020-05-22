package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: hftang
 * @Date: 2020/4/6 16:56
 * @Description: 除了可以使用yml文件来配置
 * 还可以使用类的方式来配置
 */
@Configuration
public class RoutesConfig {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route(
                "path_hftang", r -> r.path("/guonei")
                        .uri("http://news.baidu.com/gounei")).build();


        return routes.build();
    }
}
