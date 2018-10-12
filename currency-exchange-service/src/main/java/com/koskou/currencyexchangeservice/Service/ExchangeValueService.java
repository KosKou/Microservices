package com.koskou.currencyexchangeservice.Service;

import com.koskou.currencyexchangeservice.Entity.ExchangeValue;
import com.koskou.currencyexchangeservice.Repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeValueService {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    public List<ExchangeValue> findAll(){
        return exchangeValueRepository.findAll();
    }

    public ExchangeValue findOne(Long id){
        return exchangeValueRepository.findById(id).get();
    }

    public ExchangeValue findByFromAndTo(String from, String to){
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
