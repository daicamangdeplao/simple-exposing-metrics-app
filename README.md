# simple-exposing-metrics-app

A simple service that adopts ``micrometer-registry-prometheus`` in order to expose the metric, called `the_app_status`, to prometheus server.

## Implementation Notes

- After adding ``spring-boot-starter-actuator``, the endpoint `/actuator` is going to be exposed automatically.
- After adding ``implementation group: 'io.micrometer', name: 'micrometer-registry-prometheus', version: '1.10.3'``, need to add `prometheus` in order to expose the endpoint for prometheus

``` yml
management:
  endpoints:
    web:
      exposure:
        include: "health,info,prometheus"
```

## Startup

- You can start this app and access directly to ``localhost:8080/actuator/prometheus`` to see the value of metric ``the_app_status``.
- In order to use it in Prometheus, please refer to the link 6 and link 7 in the section of References.
- You can even do a further experiment like setting up an alert for checking if the app is dead or alive. For example, if `the_app_status == 0`, then do alert. 

## References

1. https://www.baeldung.com/spring-boot-actuators
2. https://www.baeldung.com/spring-boot-actuator-enable-endpoints
3. https://spring.io/blog/2018/03/16/micrometer-spring-boot-2-s-new-application-metrics-collector
4. https://prometheus.io/docs/concepts/metric_types/
5. https://micrometer.io/docs/concepts 
6. https://mokkapps.de/blog/monitoring-spring-boot-application-with-micrometer-prometheus-and-grafana-using-custom-metrics/
7. https://www.tutorialworks.com/spring-boot-prometheus-micrometer/
