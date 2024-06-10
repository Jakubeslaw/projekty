package com.bank.rest.service;

import com.bank.rest.model.CurrencyRate;
import com.bank.rest.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    public BigDecimal convertCurrency(String currencyFrom, String currencyTo, BigDecimal amount) {
        CurrencyRate correctCurrencyRate = currencyRateRepository.findConversionRate(currencyFrom, currencyTo);

        if (correctCurrencyRate == null ) {
            throw new IllegalArgumentException("Invalid currency codes");
        }

        // Perform the currency conversion

        return amount.multiply(correctCurrencyRate.getRate());
    }

    public List<CurrencyRate> getAllRates() {
        return currencyRateRepository.findAll();
    }
}