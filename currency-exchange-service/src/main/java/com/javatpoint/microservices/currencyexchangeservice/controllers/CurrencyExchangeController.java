package com.javatpoint.microservices.currencyexchangeservice.controllers;

import static org.springframework.http.HttpStatus.OK;

import com.javatpoint.microservices.currencyexchangeservice.anotation.Employee;
import com.javatpoint.microservices.currencyexchangeservice.models.DumyData;
import com.javatpoint.microservices.currencyexchangeservice.models.ExchangeValue;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @Autowired
  private Environment environment;
  private final Logger logger= LoggerFactory.getLogger(this.getClass());

  @GetMapping("/currency-exchange/from/{from}/to/{to}")//where {from} and {to} are path variable
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)  //from map to USD and to map to INR
  {

    ExchangeValue exchangeValue;
    int port = Integer.parseInt(
        Objects.requireNonNull(environment.getProperty("local.server.port")));
    Optional<ExchangeValue> exchangeValueOptional = DumyData.exchangeValueList.stream()
        .filter(ex -> ex.getFrom().equals(from) && ex.getTo().equals(to)).findFirst();
    if (exchangeValueOptional.isPresent()) {
      exchangeValue = exchangeValueOptional.get();
      exchangeValue.setPort(port);
    } else {
      exchangeValue = ExchangeValue.builder()
          .id(0L)
          .from(from)
          .to(to)
          .conversionMultiple(BigDecimal.valueOf(0))
          .port(port)
          .build();
    }
    logger.info("exchangeValue :{}", exchangeValue);

    return exchangeValue;
  }

  @PostMapping("/testAnnotation")
  public ResponseEntity<String> testAnnotation(@Valid @RequestBody Employee employee){
    System.out.println("XX");
    return ResponseEntity.status(OK).body("OK");
  }
}
