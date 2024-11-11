package com.hexagonal.product_finder.infrastructure.adapters.output;

import com.hexagonal.product_finder.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
    List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Integer brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}