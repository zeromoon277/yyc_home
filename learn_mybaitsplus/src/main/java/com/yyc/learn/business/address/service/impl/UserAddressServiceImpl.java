package com.yyc.learn.business.address.service.impl;

import com.yyc.learn.business.address.entity.UserAddress;
import com.yyc.learn.business.address.mapper.UserAddressMapper;
import com.yyc.learn.business.address.service.IUserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyc
 * @since 2020-05-15
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {
}
