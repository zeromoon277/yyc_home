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
public class Consumer04 {
    private static String EXCHANGE_NAME="exchange-topic-yyc";
    private static String QUEUE_NAME="queue-yyc-task";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = FactoryUtil.getConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "A.*");


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
        channel.basicConsume(queueName, true, deliverCallback, cancelCallback);

    }
}
