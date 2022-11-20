package com.javatpoint.microservices.currencyexchangeservice.models;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ExchangeValue {
  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionMultiple;
  private int port;
}
