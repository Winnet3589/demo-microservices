package com.javatpoint.microservices.currencyexchangeservice.models;

import java.math.BigDecimal;
import java.util.List;

public class DumyData {
  public static List<ExchangeValue> exchangeValueList;
  static {
    exchangeValueList = List.of(
        ExchangeValue.builder().id(10001L).from("USD").to("INR").conversionMultiple(BigDecimal.valueOf(65,0)).build(),
        ExchangeValue.builder().id(10002L).from("EUR").to("INR").conversionMultiple(BigDecimal.valueOf(75,0)).build(),
        ExchangeValue.builder().id(10003L).from("AUD").to("INR").conversionMultiple(BigDecimal.valueOf(25,0)).build()
    );
  }
}
