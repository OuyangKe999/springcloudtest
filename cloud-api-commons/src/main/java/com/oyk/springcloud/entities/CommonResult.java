package com.oyk.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                  //生成setter getter方法
@AllArgsConstructor   //全参数构造方法
@NoArgsConstructor    //空参构造方法
public class CommonResult<T> {
    //404 not_found
    private Integer code;
    private String message;
    private T       data;

    //定义两个参数的构造方法
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
