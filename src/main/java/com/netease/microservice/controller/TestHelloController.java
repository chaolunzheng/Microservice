package com.netease.microservice.controller;

import com.netease.microservice.model.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alun on 2018/10/27.
 * 文件描述${TODO}
 * 基本功能：测试Restful Api
 */
@RestController
public class TestHelloController {
    private final Logger log = Logger.getLogger(getClass());

    //自动注入
    @Autowired
    private Book book;

    /**
     * 注册中心服务发现 客户端
     */
    @Autowired
    private DiscoveryClient client;

    //读取配置文件
    @Value("${test.randStr.str}")
    private String val;

    @Value("${test.randNum.int}")
    private String ints;

    ServiceInstance instance;

    @RequestMapping(value = {"/li", "/"}, method = RequestMethod.GET)
    public List<String> hello() {
        instance = client.getLocalServiceInstance();
        List<String> li = new ArrayList<>();
        li.add("li1");
        li.add("li2");
        li.add("li3");
        li.add("li4");

        log.info("{/li，/},host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        return li;
    }

    @RequestMapping({"/book"})
    public String book() {
        instance = client.getLocalServiceInstance();

        log.info("/book,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());

        return book.getName() + " | " + book.getAuthor();
    }

    @RequestMapping({"/rand"})
    public String rand() {
        instance = client.getLocalServiceInstance();

        log.info("/rand,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());

        return "rand~str:" + val + "|rand~int:" + ints;
    }
}
