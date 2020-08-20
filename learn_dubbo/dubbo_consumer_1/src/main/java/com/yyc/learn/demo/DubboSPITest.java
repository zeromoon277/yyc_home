package com.yyc.learn.demo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/10 0010 下午 18:40
 */
public class DubboSPITest {
    @Test
    public void sayHello() throws Exception {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }


    @Test
    public void sayHello1() throws Exception {
        // 首先创建一个模拟用的URL对象
        URL url = URL.valueOf("dubbo://192.168.0.101:20880?robot=optimusPrime");
        // 通过ExtensionLoader获取一个PlantsWater对象,getAdaptiveExtension已经加载了所有SPI类
        Robot plantsWater = ExtensionLoader.getExtensionLoader(Robot.class)
                .getAdaptiveExtension();
        // 使用该PlantsWater调用其"自适应标注的"方法，获取调用结果
        plantsWater.sayHelloWithUrl(url);
    }
}
