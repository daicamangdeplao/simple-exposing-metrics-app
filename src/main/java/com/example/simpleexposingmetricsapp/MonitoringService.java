package com.example.simpleexposingmetricsapp;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MonitoringService {

    private final HealthEndpoint healthEndpoint;

    public MonitoringService(
            HealthEndpoint healthEndpoint
    ) {
        this.healthEndpoint = healthEndpoint;
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> healthCheckMeterRegistryCustomizer() {
        return registry -> registry.gauge(
                "the_app_status",
                healthEndpoint,
                endpoint -> determineStatus()
        );
    }

    private double determineStatus() {
        return (healthEndpoint.health().getStatus() != null && healthEndpoint.health().getStatus().equals(Status.UP))
                ? 1.0
                : 0.0;
    }
}
