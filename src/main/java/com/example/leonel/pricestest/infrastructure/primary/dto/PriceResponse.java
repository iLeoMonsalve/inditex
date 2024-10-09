package com.example.leonel.pricestest.infrastructure.primary.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceResponse {
    private Long productIdentifier;
    private String brand;
    private Double price;
}
