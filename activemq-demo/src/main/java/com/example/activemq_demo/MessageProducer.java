package com.example.activemq_demo;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private JmsTemplate jmsTemplate;

    public MessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Message message) {
//        This is a point to point model(P2P) which uses queues as there is one sender-publisher and one receiver-subscriber
        jmsTemplate.convertAndSend("Queue.example", message);
    }


}
