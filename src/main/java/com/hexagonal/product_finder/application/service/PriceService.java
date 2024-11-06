package com.hexagonal.product_finder.application.service;

import com.hexagonal.product_finder.application.port.input.GetPriceUseCase;
import com.hexagonal.product_finder.application.port.output.PriceRepositoryPort;
import com.hexagonal.product_finder.domain.exception.PriceNotFoundException;
import com.hexagonal.product_finder.domain.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceService implements GetPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    @Autowired
    public PriceService(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Price getPrice(Integer brandId, Long productId, LocalDateTime applicationDate) {
        List<Price> prices = priceRepositoryPort.findPrices(brandId, productId, applicationDate);

        return prices.stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new PriceNotFoundException("No price found for the given parameters"));
    }
}
