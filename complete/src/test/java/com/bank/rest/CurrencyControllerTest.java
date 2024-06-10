package com.bank.rest;

import com.bank.rest.Controller.CurrencyController;
import com.bank.rest.model.CurrencyRate;
import com.bank.rest.service.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrencyControllerTest {

    @Mock
    private CurrencyService currencyService;

    @InjectMocks
    private CurrencyController currencyController;

    private List<CurrencyRate> mockRates;

    @BeforeEach
    public void setup() {
        mockRates = new ArrayList<>();
        // Add mock currency rates
        mockRates.add(new CurrencyRate(1L,"USD", "EUR", BigDecimal.valueOf(0.85)));
        mockRates.add(new CurrencyRate(2L,"EUR", "USD", BigDecimal.valueOf(1.18)));
        // Add more mock rates if needed
    }

    @Test
    public void testGetAllRates() {
        // Mocking behavior of the currencyService
        when(currencyService.getAllRates()).thenReturn(mockRates);

        // Calling the controller method
        List<CurrencyRate> result = currencyController.getAllRates();

        // Assertions
        assertEquals(mockRates.size(), result.size());
        assertEquals(mockRates.get(0), result.get(0));
        assertEquals(mockRates.get(1), result.get(1));
        // Add more assertions if needed
    }

    @Test
    public void testConvert() {
        // Mocking behavior of the currencyService
        String fromCurrency = "USD";
        String toCurrency = "EUR";
        BigDecimal amount = BigDecimal.valueOf(100);
        BigDecimal expectedConvertedAmount = BigDecimal.valueOf(85);

        when(currencyService.convertCurrency(fromCurrency, toCurrency, amount))
                .thenReturn(expectedConvertedAmount);

        // Calling the controller method
        BigDecimal result = currencyController.convert(fromCurrency, toCurrency, amount);

        // Assertions
        assertEquals(expectedConvertedAmount, result);
    }
}
