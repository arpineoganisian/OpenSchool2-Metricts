package com.example.metricsproducer.config;

import com.example.dto.Metric;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

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

    /**
     * Method to configure and create a Kafka error handler.
     * It sets up an error handler with mechanisms to handle and recover from Kafka errors,
     * including publishing failed messages to a dead-letter topic and applying a fixed retry backoff strategy.
     * FixedBackOff defines a fixed delay between attempts to republish
     * a message in case of an error.
     * In this case, a delay of 1000 milliseconds (1 second) between attempts is set,
     * and the maximum number of attempts is 2.
     *
     * @param kafkaOperations Kafka operations for communication with the Kafka broker.
     * @return Configured Kafka error handler.
     */
    @Bean
    public CommonErrorHandler errorHandler(KafkaOperations<String, Metric> kafkaOperations) {
        return new DefaultErrorHandler(
                new DeadLetterPublishingRecoverer(kafkaOperations),
                new FixedBackOff(1000L, 2L)
        );
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
