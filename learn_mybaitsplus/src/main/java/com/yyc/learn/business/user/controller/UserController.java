package com.yyc.learn.business.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyc.learn.business.address.service.IUserAddressService;
import com.yyc.learn.business.user.bean.bo.UserBO;
import com.yyc.learn.business.user.entity.User;
import com.yyc.learn.business.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    private IUserService userService;

    @Autowired
    private IUserAddressService userAddressService;

    @PostMapping
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class, Error.class})
    public Long saveUser(@RequestBody UserBO userBO){
        User user = new User();
        BeanUtils.copyProperties(userBO, user);


        userService.save(user);
////        UserAddress userAddress = new UserAddress();
////        userAddress.setUserId(Convert.toInt(user.getId()));
////        userAddress.setCreateTime(LocalDateTime.now());
//        boolean res = userAddressService.saveAddress(userAddress);
        return user.getId();
    }

    @GetMapping
    public List<User> findAllUser(){

        List<User> list = userService.list();
        return list;
    }

    @GetMapping(value = "/{userId}")
    public User findByUserId(@PathVariable("userId") Long userId){
        return userService.getById(userId);
    }

    @GetMapping(value = "/age/{age}")
    public Integer countAgeThan(@PathVariable("age") Integer age){
        return userService.countAgeThan(age);
    }

    @GetMapping(value = "/{pagesize}/{pagecount}")
    public IPage<User> findByPage(@PathVariable("pagesize") Integer pagesize,
                           @PathVariable("pagecount") Long pagecount){
        IPage<User> userIPage = userService.
                selectUserPage(new Page<User>().setSize(pagesize).setCurrent(pagecount));
        return userIPage;
    }
}
