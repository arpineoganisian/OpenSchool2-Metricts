package com.example.metricsconsumer.listener;

import com.example.dto.Metric;
import com.example.metricsconsumer.config.KafkaConsumerConfig;
import com.example.metricsconsumer.mapper.MetricMapper;
import com.example.metricsconsumer.service.MetricService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    private final MetricService metricService;
    private final MetricMapper metricMapper;

    @Autowired
    public Listener(MetricService metricService, MetricMapper metricMapper) {
        this.metricService = metricService;
        this.metricMapper = metricMapper;
    }

    @KafkaListener(id = "metrics-consumer-group", topics = "metrics-topic")
    public void listen(Metric in) {
        LOGGER.info("Received: " + in);
        metricService.save(metricMapper.toEntity(in));
    }

    @KafkaListener(id = "metrics-consumer-group-DLT", topics = "metrics-topic.DLT")
    public void dltListen(Metric in) {
        LOGGER.info("Received from DLT: " + in);
    }
}
