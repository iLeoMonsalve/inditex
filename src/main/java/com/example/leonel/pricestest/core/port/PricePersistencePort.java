package com.example.leonel.pricestest.core.port;

import com.example.leonel.pricestest.core.domain.Price;

import java.sql.Timestamp;
import java.util.List;

public interface PricePersistencePort {
    List<Price> getPrice(Timestamp date, Long id, String brand);
}

