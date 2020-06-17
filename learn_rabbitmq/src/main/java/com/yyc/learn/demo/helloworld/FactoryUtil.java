package com.yyc.learn.demo.helloworld;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/17 0017 下午 12:14
 */
public class FactoryUtil {

    private volatile static ConnectionFactory connectionFactory = null;


    public static ConnectionFactory getConnectionFactory(){
        if(connectionFactory == null){
            synchronized (FactoryUtil.class){
                if(connectionFactory == null){
                    connectionFactory = new ConnectionFactory();
                    connectionFactory.setHost("148.70.168.104");
                    connectionFactory.setPort(5672);
                    connectionFactory.setVirtualHost("/yyc");
                    connectionFactory.setUsername("yyc");
                    connectionFactory.setPassword("yyc");
                    return connectionFactory;
                }
            }
        }
        return connectionFactory;
    }
}
