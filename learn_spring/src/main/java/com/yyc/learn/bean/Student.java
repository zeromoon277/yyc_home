package com.yyc.learn.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-14 20:05
 */
@Component
public class Student {

//    @Autowired
//    public Teacher teacher;


    public Student() {
        System.out.println("student info init");
    }

    public void setMyName(String name){
        System.out.println(name);
    }
}
