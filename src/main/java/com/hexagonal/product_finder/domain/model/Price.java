package com.hexagonal.product_finder.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

    private Long id;
    private Integer brandId;
    private Long productId;
    private Integer priceList;
    private Integer priority;
    private BigDecimal price;
    private String curr;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
