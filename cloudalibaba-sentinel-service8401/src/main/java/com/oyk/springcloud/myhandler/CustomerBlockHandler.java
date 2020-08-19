package com.oyk.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.oyk.springcloud.entities.CommonResult;

/**
 * @author:Ouyang Ke
 * @data:2020-08-06 21:52:23
 * @descriotion: 全局fallback
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"按客户自定义，global handlerException------1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义，global handlerException------2");
    }
}
