//package com.yyc.learn.config;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.apache.activemq.command.ActiveMQTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.config.JmsListenerContainerFactory;
//import org.springframework.jms.core.JmsTemplate;
//
//import javax.jms.ConnectionFactory;
//import javax.jms.Queue;
//import javax.jms.Session;
//import javax.jms.Topic;
//
///**
// * @Author: yyc_love_lulu
// * @Date: 2020-06-10 22:58
// */
//@Configuration
//@EnableJms
//public class ActiveMQConfig {
//    @Value("${spring.activemq.broker-url}")
//    private String host;
//    @Bean
//    public Queue queue(){
//        return new ActiveMQQueue("queue");
//    }
//
////    @Bean
////    public JmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory){
////        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
////        factory.setConnectionFactory(connectionFactory);
////        //这里必须设置为true，false则表示是queue类型
////        factory.setPubSubDomain(true);
////        return factory;
////    }
//
//    @Bean
//    public ConnectionFactory getActiveMqConnection(){
//        return new ActiveMQConnectionFactory(host);
//    }
//
//    @Bean(name="topicListenerContainerFactory")
//    public JmsListenerContainerFactory topicListenerContainerFactory(ConnectionFactory connectionFactory){
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setPubSubDomain(true);
//        factory.setSessionTransacted(false);
//        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
//        return factory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        //关闭事物
//        jmsTemplate.setSessionTransacted(false);
//        //设置为单条消息确认
//        jmsTemplate.setSessionAcknowledgeMode(4);
//        jmsTemplate.setConnectionFactory(connectionFactory);
//        return jmsTemplate;
//    }
//
//    @Bean
//    public Topic topic(){
//        return new ActiveMQTopic("topic");
//    }
//}
