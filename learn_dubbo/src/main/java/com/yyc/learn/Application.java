package com.yyc.learn;

import com.yyc.learn.service.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/3 0003 下午 17:44
 */
public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "124.70.135.171");

    public static void main(String[] args) {
        ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(DemoService.class);
        DemoService service = reference.get();
        String message = service.sayHello("dubbo");
        System.out.println(message);
    }
}
