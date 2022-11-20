package com.javatpoint.microservices.currencyconversionservice.controllers;

import com.javatpoint.microservices.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.javatpoint.microservices.currencyconversionservice.models.CurrencyConversionBean;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

  private RestTemplate restTemplate = new RestTemplate();

  @Autowired
  private CurrencyExchangeServiceProxy proxy;

  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  //where {from} and {to} represents the column
  //return a bean back
  public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
      @PathVariable BigDecimal quantity) {
    //setting variables to currency exchange service
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);

    //calling the currency-exchange-service
    ResponseEntity<CurrencyConversionBean> responseEntity = restTemplate
        .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
            CurrencyConversionBean.class, uriVariables);
    CurrencyConversionBean response = responseEntity.getBody();

    if (Objects.isNull(response)) {
      return CurrencyConversionBean.builder().build();
    }

    return CurrencyConversionBean.builder()
        .id(response.getId())
        .from(from)
        .to(to)
        .conversionMultiple(response.getConversionMultiple())
        .quantity(quantity)
        .totalCalculatedAmount(quantity.multiply(response.getConversionMultiple()))
        .port(response.getPort()).build();
  }

  @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
  //where {from} and {to} represents the column
  //return a bean back
  public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
      @PathVariable String to,
      @PathVariable BigDecimal quantity) {
    //setting variables to currency exchange service
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);

    //calling the currency-exchange-service
    CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

    if (Objects.isNull(response)) {
      return CurrencyConversionBean.builder().build();
    }

    return CurrencyConversionBean.builder()
        .id(response.getId())
        .from(from)
        .to(to)
        .conversionMultiple(response.getConversionMultiple())
        .quantity(quantity)
        .totalCalculatedAmount(quantity.multiply(response.getConversionMultiple()))
        .port(response.getPort()).build();
  }
}
