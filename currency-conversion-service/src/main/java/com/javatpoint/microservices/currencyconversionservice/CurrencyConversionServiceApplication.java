package com.javatpoint.microservices.currencyconversionservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.javatpoint.microservices.currencyconversionservice")
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CurrencyConversionServiceApplication.class, args);
  }

  //creating a bean
  @Bean
  //creating a sampler called
  public Sampler defaultSampler() {
    return Sampler.ALWAYS_SAMPLE;
  }
}
