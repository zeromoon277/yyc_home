package com.yyc.learn.service;

import java.util.List;
import java.util.Map;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/8/6 0006 下午 16:13
 */
public interface Notify {
    void oninvoke(String request);

    void onreturn(String response, String request);

    void onthrow(Throwable ex, String request);

    List<String> getInvokes();

    Map<String, String> getReturns();

    Map<String, Throwable> getExceptions();
}
