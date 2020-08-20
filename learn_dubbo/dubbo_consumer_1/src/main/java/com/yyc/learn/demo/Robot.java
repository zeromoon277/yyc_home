package com.yyc.learn.demo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/10 0010 下午 18:41
 */
@SPI
public interface Robot {

    void sayHello();

    @Adaptive
    void sayHelloWithUrl(URL url);
}
