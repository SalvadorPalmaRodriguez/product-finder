package com.hexagonal.product_finder.application.port.input;

import com.hexagonal.product_finder.domain.model.Price;

import java.time.LocalDateTime;

public interface GetPriceUseCase {
    Price getPrice(Integer brandId, Long productId, LocalDateTime applicationDate);
}
