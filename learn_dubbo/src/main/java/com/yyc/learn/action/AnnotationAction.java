package com.yyc.learn.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yyc.learn.service.AnnotationService;
import org.springframework.stereotype.Component;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/7 0007 上午 11:24
 */
@Component("annotationAction")
public class AnnotationAction {
    @Reference
    private AnnotationService annotationService;

    public String doSayHello(String name) {
        return annotationService.sayHellow(name);
    }
}
