package com.yyc.learn.action;

import com.yyc.api.demo.FruitService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/14 0014 下午 18:39
 */
@Component("fruitAction")
public class FruitAction {
    @org.apache.dubbo.config.annotation.Reference(onconnect = "onconnect")
//            (
//                    methods = {@Method(
//                            name = "findFruit",
////                            async= true,
////                            oninvoke = "notify.oninvoke",
//                            oninvoke = "demoCallback.oninvoke",
//                            onreturn = "demoCallback.onreturn",
//                            onthrow = "demoCallback.onthrow")
//                    }
//
//            )
//    @org.apache.dubbo.config.annotation.Reference(methods = {@Method(name = "createFruit", timeout = 1300, retries = 4, loadbalance = "random", async = true,
//            actives = 3, executes = 5, deprecated = true, sticky = true, oninvoke = "i", onthrow = "t", onreturn = "r", cache = "c", validation = "v",
//            arguments = {@Argument(index = 24, callback = true, type = "sss")})})
    private FruitService fruitService;

    public void onconnect(){
        System.out.println(">>>>>>>>>>>>>>>>>onconnect()");
    }
    public List<String> findAllFruit() {
        return fruitService.createFruit();
    }

    public String findFruit() {
        return fruitService.findFruit();
    }
}
