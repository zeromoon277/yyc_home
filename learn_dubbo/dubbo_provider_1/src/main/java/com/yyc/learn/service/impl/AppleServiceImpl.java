package com.yyc.learn.service.impl;

import com.yyc.api.demo.FruitService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/6 0006 下午 14:43
 */

@DubboService
public class AppleServiceImpl implements FruitService {
    @Override
    public List<String> createFruit() {
        List<String> list = new ArrayList<String>();
        list.add("生产苹果1");
        list.add("生产苹果2");
//        throw new RuntimeException("异常了");
        return list;
    }

    @Override
    public String findFruit() {
        return "apple";
    }
}
