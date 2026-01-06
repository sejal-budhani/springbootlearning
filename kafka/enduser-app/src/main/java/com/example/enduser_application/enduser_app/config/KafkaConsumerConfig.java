package com.example.enduser_application.enduser_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {

    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void update(String value) {
        System.out.println(value);
    }
}
