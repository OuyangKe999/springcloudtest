package com.oyk.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-06 22:51:31
 */
@Component
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced    //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力  默认轮询的负载机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
