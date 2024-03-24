package com.example.metricsproducer.mapper;

import com.example.dto.Metric;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;

public class MetricMapper {
    public static Metric mapToMetric(MetricsEndpoint.MetricDescriptor metric) {
        Metric mappedMetric = new Metric();
        mappedMetric.setName(metric.getName());
        mappedMetric.setDescription(metric.getDescription());
        mappedMetric.setValue(metric.getMeasurements().get(0).getValue());
        return mappedMetric;
    }
}
