package com.oyk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: OuYangKe
 * @date:2020-07-27 23:17
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8803 {
    public static void main(String[] args){
        SpringApplication.run(StreamMQMain8803.class,args);
    }
}
