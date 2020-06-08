package com.yyc.learn.business.order.service.impl;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/5/26 0026 下午 18:36
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyc.learn.business.order.entity.Order;
import com.yyc.learn.business.order.mapper.OrderMapper;
import com.yyc.learn.business.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 订单实现层
 * @author jianzh5
 * @date 2019/10/15 17:05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}