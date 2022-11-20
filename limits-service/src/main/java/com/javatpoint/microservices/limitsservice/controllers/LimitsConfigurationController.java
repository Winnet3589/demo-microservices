package com.javatpoint.microservices.limitsservice.controllers;

import com.javatpoint.microservices.limitsservice.Configuration;
import com.javatpoint.microservices.limitsservice.models.LimitConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsConfigurationController {

  private final Configuration configuration;

  @GetMapping("/limits")
  public LimitConfiguration retriveLimitsFromConfigurations()
  {
    return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
  }
}
