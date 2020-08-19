package com.oyk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: Ouyang Ke
 * @create:2020-07-21 17:15
 * @description:
 */
@SpringBootApplication
//开启图形化Hystrix Dashboard
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args){
           SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
