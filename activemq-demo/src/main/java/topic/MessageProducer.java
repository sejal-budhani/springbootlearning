package topic;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private final JmsTemplate jmsTemplate;

    public MessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String message) {
//        This is a one to many model which uses topics as there is one sender-publisher and many receiver-subscribers
        jmsTemplate.convertAndSend("Topic.example", message);
    }


}
