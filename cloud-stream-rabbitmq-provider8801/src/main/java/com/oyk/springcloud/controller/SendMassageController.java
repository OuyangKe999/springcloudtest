package com.oyk.springcloud.controller;

import com.oyk.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: OuYangKe
 * @date:2020-07-27 22:28
 * @description:
 */
@RestController
public class SendMassageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String send() {
        return messageProvider.send();
    }
}
