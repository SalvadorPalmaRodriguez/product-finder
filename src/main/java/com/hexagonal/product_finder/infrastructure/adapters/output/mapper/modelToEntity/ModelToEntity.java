package com.hexagonal.product_finder.infrastructure.adapters.output.mapper.modelToEntity;

import com.hexagonal.product_finder.domain.mapper.Mapper;
import com.hexagonal.product_finder.domain.model.Price;
import com.hexagonal.product_finder.infrastructure.entity.PriceEntity;

public interface ModelToEntity extends Mapper<Price, PriceEntity> {
}
