package com.example.simpleexposingmetricsapp;

import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class MetricController {

    @GetMapping("/greeting")
    public String  greet() {
        return "{\"Hello\": \"World\"}";
    }
}
