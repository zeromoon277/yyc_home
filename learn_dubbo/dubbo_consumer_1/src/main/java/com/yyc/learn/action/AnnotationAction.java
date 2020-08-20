package com.yyc.learn.action;

import com.google.common.collect.Lists;
import com.yyc.learn.service.AnnotationService;
import com.yyc.learn.service.impl.NotifyImpl;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/7 0007 上午 11:24
 */
@Component("annotationAction")
public class AnnotationAction {
    //    @Reference(loadbalance = "roundrobin")
//    @Reference(url = "dubbo://localhost:20880")
    @DubboReference
    private AnnotationService annotationService;

    @Autowired
    private NotifyImpl notify;

//    @DubboReference(
//            methods = {
//                    @Method(
//                            name = "createFruit",
////                            oninvoke = "notify.oninvoke",
//                            onreturn = "notify.onreturn",
//                            onthrow = "notify.onthrow")
//            }
//    )
//    private FruitService fruitService;

    public List<String> doSayHello(String name) {

//        EchoService echoService = (EchoService) fruitService; // 强制转型为EchoService
//        // 回声测试可用性
//        String ok = echoService.$echo("OK").toString();
//        System.out.println("----------" + ok);

//        List<String> fruit = fruitService.createFruit();
        annotationService.sayHellow(name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(123);
        return Lists.newArrayList();

    }


}
