package com.example.leonel.pricestest.infrastructure.config;

import com.example.leonel.pricestest.core.port.PricePersistencePort;
import com.example.leonel.pricestest.core.service.PriceService;
import com.example.leonel.pricestest.core.service.impl.PriceServiceImpl;
import com.example.leonel.pricestest.infrastructure.secondary.repository.dao.PriceDAO;
import com.example.leonel.pricestest.infrastructure.secondary.repository.repository.PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public PricePersistencePort pricePersistencePort(PriceDAO priceDAO){
        return new PriceRepository(priceDAO);
    }

    @Bean
    public PriceService priceService(PricePersistencePort pricePersistencePort) {
        return new PriceServiceImpl(pricePersistencePort);
    }
}
