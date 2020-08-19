package com.oyk.springcloud.service;

import com.oyk.springcloud.entities.CommonResult;
import com.oyk.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-06 23:00:37
 * @description: 全局服务降级以及openFeign服务调用
 */
@Component
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
