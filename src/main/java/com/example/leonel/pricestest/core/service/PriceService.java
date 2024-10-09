package com.example.leonel.pricestest.core.service;


import com.example.leonel.pricestest.core.domain.Price;
import com.example.leonel.pricestest.core.domain.PriceCommand;

public interface PriceService {
    Price getPrice(PriceCommand price);
}