package com.oyk.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author: Ouyang Ke
 * @create:2020-07-21 09:16
 * @description:
 */
@Service
public class PaymentService {

    /**
     * 服务降级
     * 正常访问，肯定ok
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池:  "+ Thread.currentThread().getName()+" paymentInfo_OK,id:"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    /**
     * 设置超时访问String paymentInfo_TimeOut(Integer id)方法，现通过服务降级 添加@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
     *             @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")})
     *             在峰值3秒以内调用paymentInfo_TimeOut(Integer id)方法、
     *             超过峰值则调用fallbackMethod方法
     *             程序运行异常比如：int age = 10/0
     *             超时 ：
     *             都会服务降级运行fallbackMethod
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    public String paymentInfo_TimeOut(Integer id){
        //暂停毫秒线程
        //int timeNumber = 5;
       // int age = 10/0;
        try{ TimeUnit.MILLISECONDS.sleep(3000); }catch(InterruptedException e){ e.printStackTrace(); }
        return "线程池:  "+ Thread.currentThread().getName()+" id:"+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): ";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池:  "+ Thread.currentThread().getName()+" 8001系统繁忙或运行报错，请稍后再试,id:"+id+"\t"+"o(╥﹏╥)o";
    }


    /**
     *服务熔断:服务的降级->进而熔断->恢复调用链路
     * 熔断打开 熔断关闭 熔断半开
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数  默认20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//10秒时间窗口期or时间范围 默认10秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0){
            throw new RuntimeException("******id  不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();  //等于 UUID.randomUUID.toString() 、hutools工具包的使用

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，o(╥﹏╥)o/~~  id："+id;
    }
}
