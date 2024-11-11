package com.hexagonal.product_finder.infrastructure.adapters.output.mapper.modelToEntity.impl;



import com.hexagonal.product_finder.domain.model.Price;
import com.hexagonal.product_finder.infrastructure.adapters.output.mapper.modelToEntity.ModelToEntity;
import com.hexagonal.product_finder.infrastructure.entity.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ModelToEntityImpl implements ModelToEntity {


    @Override
    public PriceEntity map(Price source, Optional<Map<String, Object>> mappingContext) {
        return PriceEntity.builder()
                .brandId(source.getBrandId())
                .productId(source.getProductId())
                .priceList(source.getPriceList())
                .price(source.getPrice())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .build();
    }
}
