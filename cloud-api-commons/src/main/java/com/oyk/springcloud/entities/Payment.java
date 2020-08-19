package com.oyk.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data                  //生成setter getter方法
@AllArgsConstructor   //全参数构造方法
@NoArgsConstructor    //空参构造方法
public class Payment implements Serializable {

    private Long id;
    private String serial;


}
