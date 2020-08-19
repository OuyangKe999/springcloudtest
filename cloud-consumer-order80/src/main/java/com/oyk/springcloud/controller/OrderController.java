package com.oyk.springcloud.controller;

import com.oyk.springcloud.entities.CommonResult;
import com.oyk.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    //消费者没有加入注册中心的一般调用操作
    //public static final String PAYMENT_URL = "http://localhost:8001";

    //集群之后，单机版服务消费者 通过在eureka上注册过的微服务名称调用 默认轮询
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource    //注入并实例化
    private RestTemplate restTemplate;

    @GetMapping("payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("********调用服务者8001插入成功");
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("********调用服务者8001查询成功");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
