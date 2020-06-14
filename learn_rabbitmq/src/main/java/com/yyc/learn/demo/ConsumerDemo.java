package com.yyc.learn.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-05-16 12:00
 */
public class ConsumerDemo {
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
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("路由Key" + envelope.getRoutingKey());
                System.out.println("交换机"+ envelope.getExchange());
                System.out.println("消息ID" + envelope.getDeliveryTag());
                System.out.println("接受到消息" + new String(body, "UTF-8"));

            }
        };
        channel.basicConsume(QUEUE_NAME, true, defaultConsumer);


    }
}
