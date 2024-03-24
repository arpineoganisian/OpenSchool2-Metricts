package com.example.metricsconsumer.service;

import com.example.metricsconsumer.entity.MetricEntity;
import com.example.metricsconsumer.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MetricService {

    private final MetricRepository metricRepository;

    @Autowired
    public MetricService(MetricRepository metricRepository) {
        this.metricRepository = metricRepository;
    }

    @Transactional
    public void save(MetricEntity metricEntity) {
        metricRepository.save(metricEntity);
    }

    public MetricEntity findById(Long id) {
        return metricRepository.findById(id).orElse(null);
    }

    public List<MetricEntity> findAll() {
        return metricRepository.findAll();
    }

}
