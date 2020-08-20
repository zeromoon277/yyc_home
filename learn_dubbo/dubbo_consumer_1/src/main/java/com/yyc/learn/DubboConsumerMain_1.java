package com.yyc.learn;

import com.yyc.learn.action.FruitAction;
import com.yyc.learn.config.ConsumerConfiguration;
import com.yyc.learn.service.impl.NotifyImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/7 0007 上午 11:29
 */
public class DubboConsumerMain_1 {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final FruitAction annotationAction = (FruitAction) context.getBean("fruitAction");

        NotifyImpl notify = (NotifyImpl) context.getBean("demoCallback");

        System.out.println(annotationAction.findFruit());
//        for (int i = 0; i < 10; i++) {
//            String hello = annotationAction.doSayHello("world");
//            System.out.println(hello);
//        }
        new CountDownLatch(1).await();
    }
}
