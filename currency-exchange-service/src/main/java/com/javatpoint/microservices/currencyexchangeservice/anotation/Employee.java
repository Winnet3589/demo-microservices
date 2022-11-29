package com.javatpoint.microservices.currencyexchangeservice.anotation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  @CustomMaNV(expected = "zzz", message = "Name must be enter")
  private String firstName;
}
