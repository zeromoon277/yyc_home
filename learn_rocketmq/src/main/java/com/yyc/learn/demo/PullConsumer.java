package com.yyc.learn.demo;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/28 0028 下午 16:43
 */
public class PullConsumer {
    private static final Map<MessageQueue, Long> offsetTable = new HashMap<MessageQueue, Long>();

    public static void main(String[] args) throws MQClientException {
        DefaultMQPullConsumer defaultMQPullConsumer = new DefaultMQPullConsumer("please_rename_unique_group_name");
        defaultMQPullConsumer.setNamesrvAddr("124.70.135.171:9876");
        defaultMQPullConsumer.setInstanceName("consumer");
        defaultMQPullConsumer.start();
        Set<MessageQueue> mqs = defaultMQPullConsumer.fetchSubscribeMessageQueues("my_craete_topic");
        for (MessageQueue mq : mqs) {
            System.out.printf("Consume from the queue: %s%n", mq);
            SINGLE_MQ:
            while (true) {
                try {
                    PullResult pullResult =
                            defaultMQPullConsumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 32);
                    System.out.printf("%s%n", pullResult);
                    putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                    switch (pullResult.getPullStatus()) {
                        case FOUND:
                            List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
                            for (MessageExt messageExt : msgFoundList) {
                                System.out.println(new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET));
                            }
                            break;
                        case NO_NEW_MSG:
                            break SINGLE_MQ;
                        case NO_MATCHED_MSG:
                        case OFFSET_ILLEGAL:
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    //TODO
                }
            }
        }
    }


    private static void putMessageQueueOffset(MessageQueue mq, long offset) {
        offsetTable.put(mq, offset);
    }

    private static long getMessageQueueOffset(MessageQueue mq) {
        Long offset = offsetTable.get(mq);
        if (offset != null)
            return offset;
        return 0;
    }
}
