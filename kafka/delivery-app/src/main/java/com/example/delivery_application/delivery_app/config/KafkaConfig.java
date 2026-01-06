package com.example.delivery_application.delivery_app.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(APPCONSTANTS.LOCATION_TOPIC_NAME)
//                .partitions() Can add partitions in topic
//                .replicas() Can add replicas for the topic
                .build();
    }
}
