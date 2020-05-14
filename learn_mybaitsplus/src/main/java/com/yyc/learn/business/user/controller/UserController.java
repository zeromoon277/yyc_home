package com.yyc.learn.business.user.controller;


import com.yyc.learn.business.user.entity.User;
import com.yyc.learn.business.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yyc
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;


    @GetMapping
    public List<User> findAllUser(){
        List<User> users = userMapper.selectList(null);
        return users;
    }

    @GetMapping(value = "/{userId}")
    public User findByUserId(@PathVariable("userId") String userId){
        return userMapper.selectById(userId);
    }
}
