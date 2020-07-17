package com.yyc.learn;

import com.yyc.learn.service.DemoService;
import com.yyc.learn.service.impl.DemoServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/3 0003 下午 15:11
 */
public class Provider {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "124.70.135.171");

    public static void main(String[] args) throws IOException, InterruptedException {
        ServiceConfig<DemoService> service = new ServiceConfig<DemoService>();
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }

}
