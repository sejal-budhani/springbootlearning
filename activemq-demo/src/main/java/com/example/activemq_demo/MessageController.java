package com.example.activemq_demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/publish-message/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable(value = "message") String text) {
        try {
            Message message = new Message(text);
            messageProducer.sendMessage(message);
            return ResponseEntity.ok("Message published successfully");
        } catch(Exception e) {
            return new ResponseEntity<>("Failed to publish: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
