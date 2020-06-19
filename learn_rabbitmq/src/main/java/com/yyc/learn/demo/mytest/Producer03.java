package com.yyc.learn.demo.mytest;

import com.rabbitmq.client.*;
import com.yyc.learn.demo.helloworld.FactoryUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/18 0018 下午 17:21
 */
public class Producer03 {
    private static String EXCHANGE_NAME="exchange-direct-yyc";
    private static String QUEUE_NAME="queue-yyc-task";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = FactoryUtil.getConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String message = "my test with yyc: " + QUEUE_NAME;
        for (int i = 0; i < 10; i++) {
            String m = message + i;
            channel.basicPublish(EXCHANGE_NAME, "A", null, m.getBytes("UTF-8"));
//
//            channel.basicPublish(EXCHANGE_NAME, "", null, m.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + m);
        }


    }
}
