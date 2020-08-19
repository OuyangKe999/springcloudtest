package com.oyk.springcloud.alibaba.controller;

import com.oyk.springcloud.alibaba.domain.CommonResult;
import com.oyk.springcloud.alibaba.domain.Order;
import com.oyk.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-08 17:12:51
 * @description:
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
