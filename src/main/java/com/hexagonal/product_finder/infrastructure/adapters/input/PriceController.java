package com.hexagonal.product_finder.infrastructure.adapters.input;

import com.hexagonal.product_finder.application.port.input.GetPriceUseCase;
import com.hexagonal.product_finder.infrastructure.adapters.input.mapper.response.PriceResponseMapper;
import com.hexagonal.product_finder.infrastructure.dto.PriceDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final GetPriceUseCase getPriceUseCase;
    private final PriceResponseMapper priceResponseMapper;

    @GetMapping("/price")
    public ResponseEntity<PriceDto> getPrice(
            @RequestParam @NotNull @Positive Integer brandId,
            @RequestParam @NotNull @Positive Long productId,
            @RequestParam @NotNull LocalDateTime applicationDate) {

        PriceDto priceDto = priceResponseMapper.map(getPriceUseCase.getPrice(brandId, productId, applicationDate), Optional.empty());
        return ResponseEntity.ok(priceDto);

    }

}

