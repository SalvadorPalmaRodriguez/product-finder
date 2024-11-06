package com.hexagonal.product_finder.infrastructure.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductIdValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz) || Long.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Long productId = null;

        // Si el target es un String, intenta convertirlo a Long
        if (target instanceof String) {
            String productIdStr = (String) target;
            try {
                productId = Long.valueOf(productIdStr);
            } catch (NumberFormatException e) {
                errors.rejectValue("productId", "productId.invalid", "El productId debe ser un número válido.");
                return; // Salimos si no se puede convertir
            }
        } else if (target instanceof Long) {
            productId = (Long) target;
        }

        // Realizamos la validación
        if (productId == null || productId <= 0) {
            errors.rejectValue("productId", "productId.invalid", "El productId debe ser un número positivo.");
        }
    }
}

