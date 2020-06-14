package com.yyc.learn.controller;

import com.yyc.learn.bean.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.DeliveryMode;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-11 21:33
 */
@RestController
public class MessageController {
//    @Autowired
//    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    @PostMapping(value = "/queue")
    public void sendQueue(@RequestBody MessageBean messageBean){
        jmsTemplate.convertAndSend(queue, messageBean.getMessage());
    }

    @PostMapping(value =  "/topic")
    public void sendTopic(@RequestBody MessageBean messageBean){
//        jmsTemplate.convertAndSend(topic, messageBean.getMessage());
        jmsTemplate.convertAndSend(topic, messageBean.getMessage());
    }
}
