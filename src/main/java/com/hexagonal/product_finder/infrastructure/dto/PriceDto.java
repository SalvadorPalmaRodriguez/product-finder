package com.hexagonal.product_finder.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class PriceDto {
    private Integer brandId;
    private Long productId;
    private Integer priceList;
    private BigDecimal price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
