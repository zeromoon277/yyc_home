package com.yyc.learn.exchange;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-05-16 22:37
 */
public class EProducter {

    static final String EXCHANGE_NAME = "sample_exchange";
    static final String EXCHANGE_QUEUE1= "sample_queue1";
    static final String EXCHANGE_QUEUE2 = "sample_queue2";



    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("148.70.168.104");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/yyc");
        connectionFactory.setUsername("yyc");
        connectionFactory.setPassword("yyc");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        channel.queueDeclare(EXCHANGE_QUEUE1, true, false, false, null);
        channel.queueDeclare(EXCHANGE_QUEUE2, true, false, false, null);

        channel.queueBind(EXCHANGE_QUEUE1, EXCHANGE_NAME, "");
        channel.queueBind(EXCHANGE_QUEUE2, EXCHANGE_NAME, "");
        String message = "rabbitmq 发送测试";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("已发送" + message);
        channel.close();
        connection.close();

    }
}
