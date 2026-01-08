package topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumers {

    @JmsListener(destination = "Topic.example", containerFactory = "topicListenerFactory")
    public void receiveMessage1(String message) {
        System.out.println("Message conumed by listener 1" + message);
    }

    @JmsListener(destination = "Topic.example", containerFactory = "topicListenerFactory")
    public void receiveMessage2(String message) {
        System.out.println("Message consumed by listener 2" + message);
    }
}
