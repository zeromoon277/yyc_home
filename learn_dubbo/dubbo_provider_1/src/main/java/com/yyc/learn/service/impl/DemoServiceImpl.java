package com.yyc.learn.service.impl;

import com.yyc.api.demo.DemoService;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/3 0003 下午 15:10
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello first " + name;
    }
}
