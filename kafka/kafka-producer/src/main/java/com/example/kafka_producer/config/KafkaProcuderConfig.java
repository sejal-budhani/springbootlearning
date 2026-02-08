package com.example.kafka_producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProcuderConfig {

    @Bean
    public NewTopic createTopic() {
        return new NewTopic("javatechie-demo-2", 3, (short) 1);
    }
}
