package com.javatpoint.microservices.currencyexchangeservice.controllers;

import com.javatpoint.microservices.currencyexchangeservice.models.DumyData;
import com.javatpoint.microservices.currencyexchangeservice.models.ExchangeValue;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @Autowired
  private Environment environment;


  @GetMapping("/currency-exchange/from/{from}/to/{to}")//where {from} and {to} are path variable
  public ExchangeValue retrieveExchangeValue(@PathVariable String from,
      @PathVariable String to)  //from map to USD and to map to INR
  {
    ExchangeValue exchangeValue;
    Optional<ExchangeValue> exchangeValueOptional = DumyData.exchangeValueList.stream()
        .filter(ex -> ex.getFrom().equals(from) && ex.getTo().equals(to)).findFirst();
    if (exchangeValueOptional.isPresent()) {
      exchangeValue = exchangeValueOptional.get();
      exchangeValue.setPort(Integer.parseInt(
          Objects.requireNonNull(environment.getProperty("local.server.port"))));
    } else {
      exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65), Integer.parseInt(
          Objects.requireNonNull(environment.getProperty("local.server.port"))));
    }

    return exchangeValue;
  }
}
