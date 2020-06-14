package com.yyc.learn.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-05-16 12:00
 */
public class ProducerDemo {
    static final String QUEUE_NAME = "sample_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("148.70.168.104");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/yyc");
        connectionFactory.setUsername("yyc");
        connectionFactory.setPassword("yyc");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        String message = "rabbitmq 发送测试";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("已发送" + message);
        channel.close();
        connection.close();
    }
}
