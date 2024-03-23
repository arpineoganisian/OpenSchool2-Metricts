package com.example.metricsconsumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(id = "metrics-consumer-group", topics = "metrics-topic")
    public void listen(String in) {
        LOGGER.info("Received: " + in);
    }

    @KafkaListener(id = "metrics-consumer-group-DLT", topics = "metrics-topic.DLT")
    public void dltListen(String in) {
        LOGGER.info("Received from DLT: " + in);
    }
}
