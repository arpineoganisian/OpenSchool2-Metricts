package com.example.metricsconsumer.listener;

import com.example.dto.Metric;
import com.example.metricsconsumer.config.KafkaConsumerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(id = "metrics-consumer-group", topics = "metrics-topic")
    public void listen(Metric in) {
        LOGGER.info("Received: " + in);
    }

    @KafkaListener(id = "metrics-consumer-group-DLT", topics = "metrics-topic.DLT")
    public void dltListen(Metric in) {
        LOGGER.info("Received from DLT: " + in);
    }

}
