package com.hexagonal.product_finder.infrastructure.adapters.output;


import com.hexagonal.product_finder.application.port.output.PriceRepositoryPort;
import com.hexagonal.product_finder.domain.model.Price;
import com.hexagonal.product_finder.infrastructure.adapters.output.mapper.entityToModel.EntityToModel;
import com.hexagonal.product_finder.infrastructure.entity.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;
    private final EntityToModel entityToModel;

    @Autowired
    public PriceRepositoryAdapter(JpaPriceRepository jpaPriceRepository, EntityToModel entityToModel) {
        this.jpaPriceRepository = jpaPriceRepository;
        this.entityToModel = entityToModel;
    }

    @Override
    public List<Price> findPrices(Integer brandId, Long productId, LocalDateTime applicationDate) {

        List<PriceEntity> priceEntityList = jpaPriceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                brandId, productId, applicationDate, applicationDate);
        return priceEntityList.stream()
                .map(priceEntity -> entityToModel.map(priceEntity, Optional.empty()))
                .collect(Collectors.toList());
    }


}
