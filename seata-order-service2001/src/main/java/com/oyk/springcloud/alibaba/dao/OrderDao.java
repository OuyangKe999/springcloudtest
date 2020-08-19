package com.oyk.springcloud.alibaba.dao;


import com.oyk.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-08 16:11:41
 * @description:
 */
@Mapper
public interface OrderDao {

    //1、新建订单
    void create(Order order);

    //2、修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
