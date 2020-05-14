package com.yyc.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-05-14 22:34
 */
@SpringBootApplication
@MapperScan("com.yyc.learn.business.user.mapper")
public class StartMain {
    public static void main(String[] args) {
        SpringApplication.run(StartMain.class, args);
    }
}
