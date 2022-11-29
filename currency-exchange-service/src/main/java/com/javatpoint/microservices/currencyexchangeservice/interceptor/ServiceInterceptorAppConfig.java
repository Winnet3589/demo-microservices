package com.javatpoint.microservices.currencyexchangeservice.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
  @Autowired
  ExampleHandlerInterceptor demoHandlerInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(demoHandlerInterceptor);
  }
}
