package com.example.leonel.pricestest.infrastructure.secondary.repository.repository;

import com.example.leonel.pricestest.core.domain.Price;
import com.example.leonel.pricestest.core.port.PricePersistencePort;
import com.example.leonel.pricestest.infrastructure.secondary.repository.dao.PriceDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PriceRepository implements PricePersistencePort {
    private final PriceDAO priceDAO;
    @Override
    public List<Price> getPrice(Timestamp date, Long id, String brand) {
        return priceDAO.getPrice(date,id,brand)
                .stream()
                .map(entity -> Price.builder()
                        .price(entity.getPrice())
                        .productIdentifier(entity.getProductId())
                        .brand(entity.getBrandEntity().getName())
                        .build())
                .collect(Collectors.toList());
    }
}
