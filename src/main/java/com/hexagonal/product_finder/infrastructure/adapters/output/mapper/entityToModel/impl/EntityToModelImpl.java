package com.hexagonal.product_finder.infrastructure.adapters.output.mapper.entityToModel.impl;



import com.hexagonal.product_finder.domain.model.Price;
import com.hexagonal.product_finder.infrastructure.adapters.output.mapper.entityToModel.EntityToModel;
import com.hexagonal.product_finder.infrastructure.entity.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class EntityToModelImpl implements EntityToModel {


    @Override
    public Price map(PriceEntity source, Optional<Map<String, Object>> mappingContext) {
        return Price.builder()
                .brandId(source.getBrandId())
                .productId(source.getProductId())
                .priceList(source.getPriceList())
                .price(source.getPrice())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .build();
    }
}
