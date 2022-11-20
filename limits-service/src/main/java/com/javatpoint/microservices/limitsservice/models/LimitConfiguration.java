package com.javatpoint.microservices.limitsservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class LimitConfiguration {
  private int maximum;
  private int minimum;
}
