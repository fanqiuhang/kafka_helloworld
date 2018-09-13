package com.example.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Author: fanqiuhang
 * Date: 2018/9/12 15:38
 */
public class KafkaProducer_my {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = null;
        try {
            producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                producer.send(new ProducerRecord<>("One","=" + i));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
