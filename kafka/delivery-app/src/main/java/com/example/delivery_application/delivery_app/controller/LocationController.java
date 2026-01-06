package com.example.delivery_application.delivery_app.controller;

import com.example.delivery_application.delivery_app.service.KafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    private KafkaService kafkaService;

    public LocationController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/update")
    public ResponseEntity<Map> updateLocation() {
        String location = "(" + Math.round(Math.random() * 100) + ", " + Math.round(Math.random() * 100) + ")";
        kafkaService.updateLocation(location);
        return ResponseEntity.ok(Map.of("message", "Location updated"));
    }
}
