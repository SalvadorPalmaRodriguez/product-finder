package com.hexagonal.product_finder.infrastructure.adapters.input;

import com.hexagonal.product_finder.application.port.input.GetPriceUseCase;
import com.hexagonal.product_finder.domain.exception.PriceNotFoundException;
import com.hexagonal.product_finder.infrastructure.adapters.input.mapper.response.PriceResponseMapper;
import com.hexagonal.product_finder.infrastructure.dto.PriceDto;
import com.hexagonal.product_finder.infrastructure.adapters.input.mapper.response.impl.PriceResponseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {

    private final GetPriceUseCase getPriceUseCase;
    private final PriceResponseMapper priceResponseMapper;
    private final Validator brandIdValidator;
    private final Validator productIdValidator;
    private final Validator applicationDateValidator;

    @InitBinder
    protected void initBinderForGetPrice(WebDataBinder binder) {
        binder.addValidators(brandIdValidator, productIdValidator, applicationDateValidator);
    }


    @GetMapping("/price")
    public ResponseEntity<PriceDto> getPrice(
            @RequestParam Integer brandId,
            @RequestParam Long productId,
            @RequestParam LocalDateTime applicationDate) {

        PriceDto priceDto = priceResponseMapper.map(getPriceUseCase.getPrice(brandId, productId, applicationDate), Optional.empty());
        return ResponseEntity.ok(priceDto);

    }

}

