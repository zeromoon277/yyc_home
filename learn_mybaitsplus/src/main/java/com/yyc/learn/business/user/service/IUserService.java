package com.yyc.learn.business.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yyc.learn.business.user.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yyc
 * @since 2020-05-14
 */
public interface IUserService extends IService<User> {

    Integer countAgeThan(int age);

    /**
     * @param page
     * @return
     */
    IPage<User> selectUserPage(Page<User> page);
}
