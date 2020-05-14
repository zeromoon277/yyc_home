package com.yyc.learn.controller;

import com.yyc.learn.domain.User;
import com.yyc.learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-05-14 22:40
 */
@RestController
public class HelloWordController {
    @Autowired
    private UserMapper userMapper;


    @GetMapping(value = "/user")
    public List<User> findAllUser(){
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @GetMapping(value = "/user/{userId}")
    public User findByUserId(@PathVariable("userId") String userId){
        return userMapper.selectById(userId);
    }
}
