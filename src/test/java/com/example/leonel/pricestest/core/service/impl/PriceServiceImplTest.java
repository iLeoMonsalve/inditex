package com.example.leonel.pricestest.core.service.impl;

import com.example.leonel.pricestest.core.domain.Price;
import com.example.leonel.pricestest.core.domain.PriceCommand;
import com.example.leonel.pricestest.core.port.PricePersistencePort;
import com.example.leonel.pricestest.core.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceServiceImplTest {
    PricePersistencePort pricePersistencePort;
    PriceService priceService;

    @BeforeEach
    void setUp() {
        pricePersistencePort = mock(PricePersistencePort.class);
        priceService = new PriceServiceImpl(pricePersistencePort);
    }

    @Test
    void given_valid_response_will_return_ok() {
        //arrange
        Price price = Price.builder()
                .brand("ZARA")
                .price(10.0)
                .productIdentifier(1L)
                .build();

        PriceCommand priceCommand = PriceCommand.builder()
                .date("2020-01-14-00.00.00")
                .productIdentifier(1L)
                .brand("ZARA")
                .build();

        when(pricePersistencePort.getPrice(any(Timestamp.class), anyLong(), anyString())).thenReturn(Collections.singletonList(price));

        //act
        Price response = priceService.getPrice(priceCommand);

        //asserts
        assertNotNull(response);
        assertEquals(response.getProductIdentifier(), 1L);
        assertEquals(response.getBrand(), "ZARA");
        assertEquals(response.getPrice(), 10.0);
    }

    @Test
    void given_a_empty_response_will_throw_exception() {
        //arrange
        PriceCommand priceCommand = PriceCommand.builder()
                .date("2020-01-14-00.00.00")
                .productIdentifier(1L)
                .brand("ZARA")
                .build();

        when(pricePersistencePort.getPrice(any(Timestamp.class), anyLong(), anyString())).thenReturn(Collections.emptyList());

        //act & asserts
        assertThrows(NoSuchElementException.class, () -> priceService.getPrice(priceCommand));
    }
}