package topic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/publish-message/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable(value = "message") String text) {
        try {
            messageProducer.sendMessage(text);
            return ResponseEntity.ok("Message published successfully");
        } catch(Exception e) {
            return new ResponseEntity<>("Failed to publish: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
