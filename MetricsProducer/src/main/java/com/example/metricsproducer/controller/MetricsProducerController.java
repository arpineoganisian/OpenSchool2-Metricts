package com.example.metricsproducer.controller;

import com.example.metricsproducer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsProducerController {

    private final ProducerService producerService;

    @Autowired
    public MetricsProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/metrics")
    public ResponseEntity<String> produceMetrics() {
        producerService.sendMessages();
        return ResponseEntity.ok("Metrics were sent to the Kafka topic.");
    }
}
