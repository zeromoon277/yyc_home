package com.yyc.learn.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-05-11 23:11
 */
public class KafkaConsumerDemo {
    private final KafkaConsumer<String, String> consumer;
    private KafkaConsumerDemo(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "148.70.168.104:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<String, String>(props);
    }
    void consume(){
        consumer.subscribe(Arrays.asList(KafkaProducerDemo.TOPIC));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records){
                System.out.println("I'm coming");
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }
    public static void main(String[] args) {
        KafkaConsumerDemo kafkaConsumerDemo = new KafkaConsumerDemo();
        kafkaConsumerDemo.consume();
    }
}
