package com.yyc.learn.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yyc.learn.service.AnnotationService;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/6 0006 下午 18:46
 */
@Service
public class AnnotationServiceImpl implements AnnotationService {
    public String sayHellow(String hellow) {
        return "annotation: hello, " + hellow;
    }
}
