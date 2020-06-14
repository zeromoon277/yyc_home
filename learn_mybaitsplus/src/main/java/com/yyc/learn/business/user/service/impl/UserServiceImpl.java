package com.yyc.learn.business.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyc.learn.business.user.entity.User;
import com.yyc.learn.business.user.mapper.UserMapper;
import com.yyc.learn.business.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

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
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public IPage<User> selectUserPage(Page<User> page) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //根据id进行顺序排序 id可用替换为你想进行排序的字段
        queryWrapper.orderByDesc("age");
        User user = new User();
        user.setId(472367573929820160L);
        user.setName("yyc_update2");
        user.setAge(1000);
        user.setEmail("440@qq.com");


        userMapper.updateById(user);
        return userMapper.selectPage(page, queryWrapper);
    }


    public static void main(String[] args) {
        HashMap h = new HashMap();

    }
}
