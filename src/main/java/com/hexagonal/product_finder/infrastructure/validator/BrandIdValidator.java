package com.hexagonal.product_finder.infrastructure.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BrandIdValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // Soportamos tanto String como Integer
        return String.class.isAssignableFrom(clazz) || Integer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Integer brandId = null;

        // Si el target es un String, intenta convertirlo a Integer
        if (target instanceof String) {
            String brandIdStr = (String) target;
            try {
                brandId = Integer.valueOf(brandIdStr);
            } catch (NumberFormatException e) {
                errors.rejectValue("brandId", "brandId.invalid", "El brandId debe ser un número válido.");
                return; // Salimos si no se puede convertir
            }
        } else if (target instanceof Integer) {
            brandId = (Integer) target;
        }

        // Realizamos la validación
        if (brandId == null || brandId <= 0) {
            errors.rejectValue("brandId", "brandId.invalid", "El brandId debe ser un número positivo.");
        }
    }
}

