package com.oyk.springcloud.service;

import com.oyk.springcloud.entities.CommonResult;
import com.oyk.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-06 23:01:59
 */
@Component
public class PaymentFallbackService implements  PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
