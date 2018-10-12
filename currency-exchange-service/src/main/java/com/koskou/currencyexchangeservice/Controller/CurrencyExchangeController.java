package com.koskou.currencyexchangeservice.Controller;

import com.koskou.currencyexchangeservice.Configuration.Configuration;
import com.koskou.currencyexchangeservice.Entity.ExchangeValue;
import com.koskou.currencyexchangeservice.Service.ExchangeValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    //Implement a Configuration like limits-service microservice
    @Autowired
    private Configuration configuration;
    //Best Practice
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueService exchangeValueService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        ExchangeValue exchangeValue = exchangeValueService.findByFromAndTo(from, to);

        /*HARDCODED*/
//        exchangeValue.setPort(8000);

        //Best Practice - Picking the port from the environment-> application.properties file
        /*Environment Way*/
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        /*Custom Configuration Way*/
//        exchangeValue.setPort(configuration.getPort());

        logger.info("{}", exchangeValue);

        return exchangeValue;
    }
}
