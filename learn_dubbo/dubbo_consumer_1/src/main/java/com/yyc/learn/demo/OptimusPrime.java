package com.yyc.learn.demo;

import org.apache.dubbo.common.URL;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/10 0010 下午 18:42
 */
public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }

    @Override
    public void sayHelloWithUrl(URL url) {
        System.out.println("Hello, I am Optimus Prime.");
    }
}