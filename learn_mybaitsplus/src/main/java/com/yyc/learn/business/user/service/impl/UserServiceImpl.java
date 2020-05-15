package com.yyc.learn.business.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyc.learn.business.user.entity.User;
import com.yyc.learn.business.user.mapper.UserMapper;
import com.yyc.learn.business.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyc
 * @since 2020-05-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public Integer countAgeThan(int age) {
        return userMapper.selectCount(Wrappers.<User>lambdaQuery().ge(User::getAge, age));
    }

    @Override
    public IPage<User> selectUserPage(Page<User> page) {
        return userMapper.selectPage(page, null);
    }
}
