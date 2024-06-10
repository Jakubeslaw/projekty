package com.bank.rest.repository;

import com.bank.rest.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

    @Query("SELECT cr FROM CurrencyRate cr WHERE cr.currencyFrom = :currencyFrom AND cr.currencyTo = :currencyTo")
    CurrencyRate findConversionRate(@Param("currencyFrom") String currencyFrom, @Param("currencyTo") String currencyTo);

    CurrencyRate findById(long id);
}