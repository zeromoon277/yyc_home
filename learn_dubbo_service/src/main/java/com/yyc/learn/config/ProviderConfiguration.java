package com.yyc.learn.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/6 0006 下午 18:48
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.yyc.learn.service.impl")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProviderConfiguration {
}
