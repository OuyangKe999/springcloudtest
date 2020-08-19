package com.oyk.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.oyk.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: Ouyang Ke
 * @create:2020-07-21 10:01
 * @description:
 */
@RestController
@Slf4j
//不是使用PaymentFallbackService类里面的paymentInfo_TimeOut处理异常，因为这里已经声明了全局fallback
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }


   /*@GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }*/

    /**
     * 设置超时访问String paymentInfo_TimeOut(Integer id)方法，现通过服务降级 添加@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
     *              @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")})
     *              在峰值3秒以内调用paymentInfo_TimeOut(Integer id)方法、
     *              超过峰值则调用fallbackMethod方法
     *              程序运行时异常比如：int age = 10/0
     *              超时 ：
     *              都会服务降级运行fallbackMethod
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
/*    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")})*/
    @HystrixCommand   //调用全局fallbackMethod
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        
        //int age = 10/0;  自己运行异常出错 调用fallbackMethod方法
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己o(╥﹏╥)o";
    }

    /**
     * 全局fallback需要在类头加一个@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")注解，
     * 需要有payment_Global_FallbackMethod（）方法以及 @HystrixCommand搭配使用
     * 如果@HystrixCommand写了自己的fallbackMethod就用自己的否则就用全局的
     * @return
     */
    //下面是全局fallback
    public String payment_Global_FallbackMethod(){
     return "Global异常处理信息，请稍后再试，/(꒦_꒦)/~~";
    }
}
