package com.oyk.springcloud.alibaba.service;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-08 17:53:09
 * @description:
 */
public interface StorageService {

    //扣减库存
    public void decrease(Long productId, Integer count);
}
