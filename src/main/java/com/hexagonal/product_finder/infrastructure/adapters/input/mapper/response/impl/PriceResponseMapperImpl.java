package com.hexagonal.product_finder.infrastructure.adapters.input.mapper.response.impl;

import com.hexagonal.product_finder.domain.model.Price;
import com.hexagonal.product_finder.infrastructure.adapters.input.mapper.response.PriceResponseMapper;
import com.hexagonal.product_finder.infrastructure.dto.PriceDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class PriceResponseMapperImpl implements PriceResponseMapper {
    @Override
    public PriceDto map(Price source, Optional<Map<String, Object>> mappingContext) {
        return PriceDto.builder()
                .brandId(source.getBrandId())
                .productId(source.getProductId())
                .priceList(source.getPriceList())
                .price(source.getPrice())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .build();
    }
}
