package com.example.metricsproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {

    /**
     * Creates a new Kafka topic named "metrics-topic", configures it with 10 partitions
     * and 1 replica, and returns it for processing metrics.
     */
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("metrics-topic")
                .partitions(10)
                .replicas(1)
                .build();
    }

    /**
     * Creates and returns a Kafka topic object for processing Dead Letter Topic (DLT).
     * DLT (Dead Letter Topic) is a Kafka topic where messages are redirected
     * that could not be processed in the main topic.
     */
    @Bean
    public NewTopic dlt() {
        return TopicBuilder.name("metrics-topic.DLT")
                .partitions(1)
                .replicas(1)
                .build();
    }

//    @Bean
//    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
//        return args -> {
//            template.send("metrics-topic", "test");
//        };
//    }

//    @Bean
//    public RecordMessageConverter converter() {
//        return new JsonMessageConverter();
//    }
}
