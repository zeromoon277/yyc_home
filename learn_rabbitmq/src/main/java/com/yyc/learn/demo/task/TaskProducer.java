package com.yyc.learn.demo.task;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import com.yyc.learn.demo.helloworld.FactoryUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/17 0017 下午 14:32
 */
public class TaskProducer {
    private static final String TASK_QUEUE_NAME = "task_queue1";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = FactoryUtil.getConnectionFactory();
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        //设置队列的过期时间10s
        Map<String,Object> param = new HashMap<>();
        param.put("x-message-ttl", 10000);

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, param);

        String message = String.join(" ", args);
        channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));

    }
}
