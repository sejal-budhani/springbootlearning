package com.example.kafka_producer.controller;

import com.example.kafka_producer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class MessageProducer {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable String message) {
        try {
            for (int i = 0; i < 10000; i++) {
                kafkaMessagePublisher.sendMessageToTopic(message + i);
            }
            return ResponseEntity.ok("Message published successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
