package com.yyc.learn.bean;

import lombok.Data;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-11 21:34
 */
@Data
public class MessageBean {
    private String topic;
    private String queue;
    private String message;
}
