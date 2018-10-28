package com.netease.microservice.controller;

import com.netease.microservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
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
    //自动注入
    @Autowired
    private  Book book;

    //读取配置文件
    @Value("${test.randStr.str}")
    private String val;

    @Value("${test.randNum.int}")
    private String ints;

    @RequestMapping({"/li", "/"})
    public List<String> hello() {
        List<String> li = new ArrayList<>();
        li.add("li1");
        li.add("li2");
        li.add("li3");
        li.add("li4");
        return li;
    }

    @RequestMapping({"/book"})
    public String book() {
        return book.getName()+" | "+book.getAuthor();
    }

    @RequestMapping({"/rand"})
    public String rand() {
        return "rand~str:"+val+"|rand~int:"+ints;
    }
}
