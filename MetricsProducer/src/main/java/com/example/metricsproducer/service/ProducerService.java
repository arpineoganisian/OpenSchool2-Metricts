package com.example.metricsproducer.service;

import com.example.dto.Metric;
import com.example.metricsproducer.mapper.MetricMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);
    private final KafkaTemplate<String, Metric> kafkaTemplate;
    private final MetricsService metricsService;

    @Autowired
    public ProducerService(KafkaTemplate<String, Metric> kafkaTemplate, MetricsService metricsService) {
        this.kafkaTemplate = kafkaTemplate;
        this.metricsService = metricsService;
    }

    public void sendMessages() {
        sendMessage("system.cpu.count");
        sendMessage("system.cpu.usage");
        sendMessage("system.load.average.1m");
    }

    public void sendMessage(String metricName) {
        MetricsEndpoint.MetricDescriptor descriptor = metricsService.getMetric(metricName);
        Metric metric = MetricMapper.mapToMetric(descriptor);
        LOGGER.info("Sending message: {}", metric);
        kafkaTemplate.send("metrics-topic", metric);
    }
}
