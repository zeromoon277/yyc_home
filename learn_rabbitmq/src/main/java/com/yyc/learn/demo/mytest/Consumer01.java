package com.yyc.learn.demo.mytest;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.*;
import com.yyc.learn.demo.helloworld.FactoryUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/18 0018 下午 15:45
 */
public class Consumer01 {
    private final static String EXCHANGE_NAME = "exchange-yyc";
    private final static String QUEUE_NAME = "queue-yyc";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = FactoryUtil.getConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                System.out.println("consumerTag：" + consumerTag);
                System.out.println(new String(message.getBody()));
                System.out.println(JSONObject.toJSONString(message));
                System.out.println("----------------------");
            }
        };

        CancelCallback cancelCallback = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
                System.out.println("cancelCallback：" + consumerTag);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

    }
}
