package com.example.metricsconsumer.controller;

import com.example.metricsconsumer.entity.MetricEntity;
import com.example.metricsconsumer.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricsConsumerController {

    MetricService metricService;

    @Autowired
    public MetricsConsumerController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping("/metrics")
    public ResponseEntity<List<MetricEntity>> consumeMetrics() {
        return ResponseEntity.ok(metricService.findAll());
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricEntity> consumeMetricsById(@PathVariable Long id) {
        return ResponseEntity.ok(metricService.findById(id));
    }
}
