package com.yyc.learn.demo;

import com.yyc.learn.bean.Student;
import com.yyc.learn.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-14 20:04
 */
public class AppTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(BeanConfig.class);


        Student bean = context.getBean(Student.class);
        bean.setMyName("ceshi");
        System.out.println(bean);
//        System.out.println(bean.teacher);
//        Student bean1 = context.getBean(Student.class);

//        System.out.println(bean1);
//        System.out.println(bean1.teacher);


    }
}
