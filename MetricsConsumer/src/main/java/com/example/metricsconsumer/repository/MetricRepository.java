package com.example.metricsconsumer.repository;

import com.example.metricsconsumer.entity.MetricEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<MetricEntity, Long> {
}
