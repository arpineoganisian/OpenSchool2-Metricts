package com.example.metricsproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MetricsService {

    private static final String URL = "http://localhost:8080/actuator/metrics/";

    private final RestTemplate restTemplate;

    @Autowired
    MetricsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMetric(String metricName) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL + metricName, String.class);
        return responseEntity.getBody();
    }
}
