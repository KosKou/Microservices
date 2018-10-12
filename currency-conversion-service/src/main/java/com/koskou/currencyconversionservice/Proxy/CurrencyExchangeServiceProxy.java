package com.koskou.currencyconversionservice.Proxy;

import com.koskou.currencyconversionservice.Entity.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*Without Ribbon*/
//@FeignClient(name = "currency-exchange-service",url = "localhost:8000") //The name must be the name of
// application.properties of the Service u are going to use
/*With Ribbon*/
//@FeignClient(name = "currency-exchange-service") //Config With Ribbon
@FeignClient(name = "netflix-zuul-api-gateway-server") //Config With Ribbon & Zuul Api
@RibbonClient(name = "currency-exchange-service")//Load Balancer
public interface CurrencyExchangeServiceProxy {

//    @GetMapping("currency-exchange/from/{from}/to/{to}") Without Zuul
    @GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}") //With Zuul
    public CurrencyConversionBean retrieveExchangeValue(
            @PathVariable("from") String from, @PathVariable("to") String to);
}
