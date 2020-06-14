package com.yyc.learn.service;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-10 22:14
 */
public interface IMQService {

    boolean sendMessage(String topic, String message);

    String reveiceMessage(String topic);
}
