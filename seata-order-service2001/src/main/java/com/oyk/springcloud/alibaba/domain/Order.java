package com.oyk.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: Ouyang Ke
 * @create: 2020-08-08 16:03:38
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    /**
     *用户id
     */
    private Long userId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完成
     */
    private Integer status;
}
