package com.javatpoint.microservices.currencyexchangeservice;

//import brave.sampler.Sampler;
//import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableAdminServer
@EnableScheduling
public class CurrencyExchangeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
  }

  //creating a bean
//  @Bean
//  //creating a sampler called
//  public Sampler defaultSampler() {
//    return Sampler.ALWAYS_SAMPLE;
//  }
}
