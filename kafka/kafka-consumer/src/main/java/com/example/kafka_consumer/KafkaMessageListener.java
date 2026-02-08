package com.example.kafka_consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaMessageListener {

    private Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "javatechie-demo-2", groupId = "group2")
    public void consume1(String message) {
        logger.info("Consumer1 consumed message : " + message);
    }

    @KafkaListener(topics = "javatechie-demo-2", groupId = "group2")
    public void consume2(String message) {
        logger.info("Consumer2 consumed message : " + message);
    }

    @KafkaListener(topics = "javatechie-demo-2", groupId = "group2")
    public void consume3(String message) {
        logger.info("Consumer3 consumed message : " + message);
    }

    @KafkaListener(topics = "javatechie-demo-2", groupId = "group2")
    public void consume4(String message) {
        logger.info("Consumer4 consumed message : " + message);
    }
}
