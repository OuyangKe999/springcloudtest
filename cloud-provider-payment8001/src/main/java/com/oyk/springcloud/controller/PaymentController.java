package com.oyk.springcloud.controller;


import com.oyk.springcloud.entities.CommonResult;
import com.oyk.springcloud.entities.Payment;
import com.oyk.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import sun.nio.ch.DefaultSelectorProvider;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    //集群
    @Value("${server.port}")
    private  String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private PaymentService paymentService;


    @PostMapping("create")
    //添加@RequestBody 不然消费者服务调用只能插入主键数据
    public CommonResult<Payment> create(@RequestBody Payment payment){
       int result =  paymentService.create(payment);
       log.info("*****插入结果："+result);

       if(result > 0){
           return new CommonResult(200,"插入数据成功,serverPort"+serverPort,result);
       }
       else{
           return new CommonResult(444,"插入数据库失败",null);
       }
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment =  paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);

        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
        }
        else{
            return new CommonResult(444,"没有对应记录，查询ID"+id,null);
        }
    }

    @GetMapping("discovery")
    public Object discovery(){
        //获取Eureka-Server服务清单列表
        List<String> services = discoveryClient.getServices();
        //输入iter快捷出来
        for (String element : services) {
            log.info("*********element:"+element);
        }
        //根据微服务名称获取相关信息    instances一个微服务的全部具体实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        /*
           List[0] instance = 127.0.0.1:8002
           List[1] instance = 127.0.0.1:8001
         */
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }


    //测试OpenFeign超时
    @GetMapping("feign/timeout")
    public String paymentFeignTimeout(){
        //暂停几秒钟线程
        try{
           TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
           e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
