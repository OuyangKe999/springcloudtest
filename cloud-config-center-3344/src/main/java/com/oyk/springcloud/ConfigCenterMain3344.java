package com.oyk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: OuYangKe
 * @date:2020-07-25 20:52
 * @description:  结合bus消息总线 curl -X POST "http://localhost:3344/actuator/bus-refresh "
 *
 * 指定具体某一种实例生效而不是全部  description = 服务名：端口
 * http://localhost:配置中心的端口号/actuator/bus-refresh/{description}
 * 只通知3355 不通知3366
 * curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355 "
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args){
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
