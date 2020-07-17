package com.yyc.learn.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/7 0007 上午 11:26
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.yyc.learn.action")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
@ComponentScan(value = {"com.yyc.learn.action"})
public class ConsumerConfiguration {
}
