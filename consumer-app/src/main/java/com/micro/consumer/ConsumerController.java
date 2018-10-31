package com.micro.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by alun on 2018/10/31.
 * 文件描述${TODO}
 * 基本功能：消费者实例演示
 */
@RestController
public class ConsumerController {
    /**
     * 通过访问服务注册中心的服务名  和实际的服务提供者解耦 实现高可用和负载均衡
     */
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon",method = RequestMethod.GET)
    public String helloConsumer(){
        //根据协议 调用远程服务
        String res =restTemplate.getForEntity("http://myFirst-SpringBoot/book",String.class).getBody();
        return res;
    }

}
