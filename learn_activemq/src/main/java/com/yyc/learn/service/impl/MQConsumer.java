package com.yyc.learn.service.impl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;


/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-10 23:02
 */
@Component
public class MQConsumer {

//    @JmsListener(destination = "queue")
//    public void ListenQueue(String msg){
//        System.out.println("接收到queue消息：" + msg);
//    }

//    @JmsListener(destination = "queue")
//    public void receive(TextMessage message, Session session) throws JMSException, InterruptedException {
//
//        String msgid = message.getJMSMessageID();
//        String msg = message.getText();
//        System.out.println("监听器收到msg:" + msg + "消息id" + msgid);
////        message.acknowledge();
//    }

//    @JmsListener(destination="topic", containerFactory =
//            "topicListenerContainerFactory")
//    public void ListenTopic(String msg){
//        System.out.println("接收到topic消息：" + msg);
//    }


//    @JmsListener(destination="topic", containerFactory =
//            "topicListenerContainerFactory")
//    public void receiveQueue(final TextMessage textMessage, Session session){
//        try{
//            System.out.println("接收到topic消息：" + textMessage.getText());
////            textMessage.acknowledge();
////            session.recover();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    @JmsListener(destination = "queue1", containerFactory = "jmsQueueListener")
    public void receiveQueue(final TextMessage text, Session session)
            throws JMSException {
        try {
            System.out.println("Consumer收到的报文为:" + text.getText());
//            text.acknowledge();// 使用手动签收模式，需要手动的调用，如果不在catch中调用session.recover()消息只会在重启服务后重发
        } catch (Exception e) {
            session.recover();// 此不可省略 重发信息使用
        }
    }

}
