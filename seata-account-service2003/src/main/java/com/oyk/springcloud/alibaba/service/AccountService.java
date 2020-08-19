package com.oyk.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-08 21:33:50
 * @description:
 */
public interface AccountService {

     void decrease(Long userId, BigDecimal money);
}
