package com.oyk.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: OuYangKe
 * @date:2020-07-31 07:14
 * @description: Ribbon 集成负载均衡以及RestTemplate
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //开启负载均衡 RestTemplate结合Ribbon使用负载均衡时
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
