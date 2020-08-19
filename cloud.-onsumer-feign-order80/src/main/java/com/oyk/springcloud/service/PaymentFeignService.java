package com.oyk.springcloud.service;

import com.oyk.springcloud.entities.CommonResult;
import com.oyk.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
//Feign自带负载均衡配置项
public interface PaymentFeignService {

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //测试OpenFeign超时
    @GetMapping("payment/feign/timeout")
    public String paymentFeignTimeout();

}
