package com.hexagonal.product_finder.application.port.output;

import com.hexagonal.product_finder.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {
    List<Price> findPrices(Integer brandId, Long productId, LocalDateTime applicationDate);
}
