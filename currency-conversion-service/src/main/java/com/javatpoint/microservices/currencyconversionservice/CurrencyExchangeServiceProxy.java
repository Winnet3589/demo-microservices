package com.javatpoint.microservices.currencyconversionservice;
import com.javatpoint.microservices.currencyconversionservice.models.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchange-service", url="http://localhost:8000")

//Enabling feign, //enabling ribbon
//@FeignClient(name="currency-exchange-service")
//@RibbonClient(name="currency-exchange-service")

// Zuul
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy
{
  // feign, ribbon
  // @GetMapping("/currency-exchange/from/{from}/to/{to}")		//where {from} and {to} are path variable

  // Zuul. mapping for zuul-api-gateway-server
  @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
  CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
      @PathVariable("to") String to); //from map to USD and to map to INR
}