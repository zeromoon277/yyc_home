package com.yyc.learn.business.user.service.impl;

import com.yyc.learn.business.user.entity.User;
import com.yyc.learn.business.user.mapper.UserMapper;
import com.yyc.learn.business.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
