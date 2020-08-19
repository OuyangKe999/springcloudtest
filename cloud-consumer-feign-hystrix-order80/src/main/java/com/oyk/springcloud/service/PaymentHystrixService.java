package com.oyk.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Ouyang Ke
 * @create:2020-07-21 09:58
 * @description:统一为接口里面的方法进行异常处理,如果接口方法出错、服务器宕机、则调用PaymentFallbackService.class类的方法处理
 *              不能和PaymentController里的全局fallback一起使用，不然会优先调用全局fallback方法比如这里的 paymentInfo_TimeOut（）
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT" ,fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);


}
