package com.bank.rest.Controller;

import com.bank.rest.model.CurrencyRate;
import com.bank.rest.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public List<CurrencyRate> getAllRates() {
        return currencyService.getAllRates();
    }

    @GetMapping("/convert")
    public BigDecimal convert(
            @RequestParam String fromCurrency,
            @RequestParam String toCurrency,
            @RequestParam BigDecimal amount) {
        return currencyService.convertCurrency(fromCurrency, toCurrency, amount);
    }
}