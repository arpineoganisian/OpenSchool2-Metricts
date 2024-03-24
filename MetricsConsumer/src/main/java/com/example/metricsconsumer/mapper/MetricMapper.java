package com.example.metricsconsumer.mapper;

import com.example.dto.Metric;
import com.example.metricsconsumer.entity.MetricEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MetricMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public MetricMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MetricEntity toEntity(Metric metric) {
        MetricEntity metricEntity = modelMapper.map(metric, MetricEntity.class);
        metricEntity.setTimestamp(LocalDateTime.now());
        return metricEntity;
    }
}
