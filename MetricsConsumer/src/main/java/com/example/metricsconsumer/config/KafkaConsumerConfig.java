package com.example.metricsconsumer.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
