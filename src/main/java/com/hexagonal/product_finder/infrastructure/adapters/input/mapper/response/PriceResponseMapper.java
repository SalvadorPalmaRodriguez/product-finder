package com.hexagonal.product_finder.infrastructure.adapters.input.mapper.response;

import com.hexagonal.product_finder.domain.mapper.Mapper;
import com.hexagonal.product_finder.domain.model.Price;
import com.hexagonal.product_finder.infrastructure.dto.PriceDto;

public interface PriceResponseMapper extends Mapper<Price, PriceDto> {
}
