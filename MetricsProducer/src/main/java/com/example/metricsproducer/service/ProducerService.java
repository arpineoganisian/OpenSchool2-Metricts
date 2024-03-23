package com.example.metricsproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MetricsService metricsService;

    @Autowired
    public ProducerService(KafkaTemplate<String, String> kafkaTemplate, MetricsService metricsService) {
        this.kafkaTemplate = kafkaTemplate;
        this.metricsService = metricsService;
    }

    public void sendMessage() {
        String message1 = metricsService.getMetric("kafka.producer.request.total");
        String message2 = metricsService.getMetric("kafka.producer.response.total");
        LOGGER.info("Sending message: {}", message1);
        kafkaTemplate.send("metrics-topic", message1);
        LOGGER.info("Sending message: {}", message2);
        kafkaTemplate.send("metrics-topic", message2);
    }
}
