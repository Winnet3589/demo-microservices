package com.javatpoint.microservices.currencyexchangeservice.anotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumNamePatternValidator implements ConstraintValidator<CustomMaNV, String> {
  private String name;

  @Override
  public void initialize(CustomMaNV enumNames) {
    this.name = enumNames.expected();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }

    return name.equals(value);
  }
}
