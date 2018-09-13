package com.example.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;


/**
 * Created with IntelliJ IDEA.
 * Author: fanqiuhang
 * Date: 2018/9/12 16:16
 */
public class KafkaConsumer_my {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer consumer = new KafkaConsumer(properties);
        consumer.subscribe(Arrays.asList("One"));
        while (true) {
            ConsumerRecords<String,String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("offect ->" + record.offset() + "key ->" + record.key() + "value ->" + record.value());
            }
        }
    }
}
