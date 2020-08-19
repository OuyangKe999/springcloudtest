package com.oyk.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-08 17:58:38
 * @description:
 */
@Mapper
public interface StorageDao {

    //扣减库存
    public void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
