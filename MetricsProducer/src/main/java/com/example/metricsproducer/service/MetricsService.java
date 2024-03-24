package com.example.metricsproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {
    private final MetricsEndpoint metricsEndpoint;

    @Autowired
    MetricsService(MetricsEndpoint metricsEndpoint) {
        this.metricsEndpoint = metricsEndpoint;
    }

    public MetricsEndpoint.MetricDescriptor getMetric(String metricName) {
        return metricsEndpoint.metric(metricName, null);
    }
}
