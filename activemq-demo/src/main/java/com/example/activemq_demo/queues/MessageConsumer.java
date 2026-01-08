package com.example.activemq_demo.queues;

import com.example.activemq_demo.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "Queue.example")
    public void receiveMessage(Message message) {
        System.out.println("Message received: " + message.getText());
    }
}
