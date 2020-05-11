package com.yyc.learn.demo;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-05-11 23:10
 */
public class KafkaProducerDemo {
    private final Producer<String, String> kafkaProdcer;

    public final static String TOPIC = "JAVA_TOPIC";

    private KafkaProducerDemo() {
        kafkaProdcer = createKafkaProducer();
    }

    private Producer<String, String> createKafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "148.70.168.104:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);
        return kafkaProducer;
    }

    void produce() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final String key = "key" + i;
            String data = "hello kafka message:" + key;
            kafkaProdcer.send(new ProducerRecord<String, String>(TOPIC, key, data), new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    System.out.println("发送key" + key + "成功");
                }
            });
        }
    }

    public static void main(String[] args) {
        KafkaProducerDemo kafkaProducerDemo = new KafkaProducerDemo();
        kafkaProducerDemo.produce();
    }

}