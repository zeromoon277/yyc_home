package com.yyc.learn.demo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/19 0019 下午 17:59
 */
public class SyncProducer2 {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("sync-producer-group");
        // Specify name server addresses.
        producer.setNamesrvAddr("124.70.135.171:9876");
        //Launch the instance.
        producer.start();

//        producer.createTopic("yyc", "my_craete_topic", 1);

        for (int i = 0; i < 80; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("my_craete_topic-2" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
