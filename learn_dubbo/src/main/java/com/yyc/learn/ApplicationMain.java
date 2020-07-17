package com.yyc.learn;

import com.yyc.learn.action.AnnotationAction;
import com.yyc.learn.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/7 0007 上午 11:29
 */
public class ApplicationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
        String hello = annotationAction.doSayHello("world");
        System.out.println(hello);
    }
}
