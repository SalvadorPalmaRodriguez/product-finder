package com.hexagonal.product_finder.domain.mapper;

import java.util.Map;
import java.util.Optional;

public interface Mapper <S, T> {
    T map(S source, Optional<Map<String, Object>> mappingContext);
}
