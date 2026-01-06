package com.example.delivery_application.delivery_app.service;

import com.example.delivery_application.delivery_app.config.APPCONSTANTS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    for logging
    Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location) {
        logger.info(location);
        kafkaTemplate.send(APPCONSTANTS.LOCATION_TOPIC_NAME, location);
        return true;
    }
}
