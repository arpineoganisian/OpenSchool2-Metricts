package com.example.metricsproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;


@Configuration
public class KafkaProducerConfig {

    /**
     * Метод создает новый топик Kafka с именем "metrics-topic", конфигурирует его с 10 разделами
     * и одной репликой и возвращает для обработки метрик.
     */
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("metrics-topic")
                .partitions(10)
                .replicas(1)
                .build();
    }

    /**
     * Метод создает и возвращает объект темы Kafka для обработки Dead Letter Topic (DLT).
     * DLT (Dead Letter Topic) - это тема Kafka, куда перенаправляются сообщения,
     * которые не удалось обработать в основной теме.
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

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }
}
