package com.hexagonal.product_finder.infrastructure.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class ApplicationDateValidator implements Validator {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    @Override
    public boolean supports(Class<?> clazz) {
        // Se soporta tanto String como LocalDateTime
        return String.class.isAssignableFrom(clazz) || LocalDateTime.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LocalDateTime applicationDate = null;

        // Verificamos si el target es un String
        if (target instanceof String) {
            String dateStr = (String) target;
            try {
                applicationDate = LocalDateTime.parse(dateStr, formatter);
            } catch (DateTimeParseException e) {
                errors.rejectValue("applicationDate", "applicationDate.invalid", "La fecha de aplicación no es válida.");
                return; // Salimos si no se puede convertir
            }
        } else if (target instanceof LocalDateTime) {
            applicationDate = (LocalDateTime) target;
        }

        // Validamos la fecha de aplicación
        if (applicationDate == null) {
            errors.rejectValue("applicationDate", "applicationDate.null", "La fecha de aplicación no puede ser nula.");
        } else if (applicationDate.isBefore(LocalDateTime.now())) {
            errors.rejectValue("applicationDate", "applicationDate.past", "La fecha de aplicación no puede estar en el pasado.");
        }
    }
}
