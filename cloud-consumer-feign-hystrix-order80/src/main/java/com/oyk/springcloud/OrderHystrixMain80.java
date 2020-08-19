package com.oyk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: Ouyang Ke
 * @create:2020-07-21 09:56
 * @description:
 */
@SpringBootApplication

@EnableFeignClients

@EnableHystrix

public class OrderHystrixMain80 {
    public static void main(String[] args){
           SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
