package com.yyc.learn.business.address.service;

import com.yyc.learn.business.address.entity.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yyc
 * @since 2020-05-15
 */
public interface IUserAddressService extends IService<UserAddress> {

    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = {RuntimeException.class, Error.class})
    default boolean saveAddress(UserAddress entity) {
        save(entity);
        int i = 1/0;
        return true;
    }
}
