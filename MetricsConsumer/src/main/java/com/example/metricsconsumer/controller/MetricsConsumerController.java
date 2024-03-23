package com.example.metricsconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsConsumerController {
    @GetMapping("/metrics")
    public void consumeMetrics() {
        // Consume metrics
    }

    @GetMapping("/metrics/{id}")
    public void consumeMetricsById(@PathVariable Long id) {
        // Consume metrics by id
    }
}
