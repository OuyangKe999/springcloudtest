package com.oyk.springcloud.alibaba.service;

import com.oyk.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-08 16:38:34
 * @description:
 */
public interface OrderService {

    void create(Order order);

}
