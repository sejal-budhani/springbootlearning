package com.example.kafka_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(String message) {
//        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("topic-example", message);
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("javatechie-demo-2", message);
        future.whenComplete((result, exception) -> {
            if(exception == null) {
                System.out.println("Send message = [" + message + " ] with offset = [" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send the message [" + message + "] due to " + exception.getMessage());
            }
        });

    }
}
