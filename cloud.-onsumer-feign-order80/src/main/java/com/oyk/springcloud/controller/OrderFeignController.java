package com.oyk.springcloud.controller;

import com.oyk.springcloud.entities.CommonResult;
import com.oyk.springcloud.entities.Payment;
import com.oyk.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    //测试OpenFeign超时
    @GetMapping("payment/feign/timeout")
    public String paymentFeignTimeout(){

        //OpenFeign-ribbon  客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }


}
