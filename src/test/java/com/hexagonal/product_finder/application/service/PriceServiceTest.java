package com.hexagonal.product_finder.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import com.hexagonal.product_finder.application.port.output.PriceRepositoryPort;
import com.hexagonal.product_finder.domain.exception.PriceNotFoundException;
import com.hexagonal.product_finder.domain.model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort; // Mock del repositorio

    @InjectMocks
    private PriceService priceService; // Servicio que se va a probar

    @BeforeEach
    public void setUp() {
        // No es necesario inicializar los mocks con MockitoExtension
    }
    @Test
    public void testGetPriceReturnsHighestPriority() {
        // Crear datos de prueba
        Price price1 = new Price(1L, 1, 35455L, 1, 1, new BigDecimal("35.50"), "EUR", LocalDateTime.parse("2020-06-14T10:00:00"), LocalDateTime.parse("2020-06-14T10:00:00"));
        Price price2 = new Price(2L, 1, 35455L, 2, 2, new BigDecimal("25.45"), "EUR", LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"));

        // Simular el comportamiento del repositorio
        when(priceRepositoryPort.findPrices(anyInt(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(Arrays.asList(price1, price2)); // Devuelve una lista con los precios

        // Ejecutar el método y verificar el resultado
        Price result = priceService.getPrice(1, 35455L, LocalDateTime.parse("2020-06-14T16:00:00"));

        // Debería devolver el precio con la prioridad más alta
        assertEquals(price2, result);
    }
    @Test
    public void testGetPriceThrowsExceptionWhenNoPriceFound() {
        // Simular el comportamiento del repositorio para no encontrar precios
        when(priceRepositoryPort.findPrices(anyInt(), anyLong(), any(LocalDateTime.class)))
                .thenReturn(Collections.emptyList());

        // Verificar que se lanza la excepción
        assertThrows(PriceNotFoundException.class, () -> {
            priceService.getPrice(1, 99999L, LocalDateTime.parse("2020-06-14T10:00:00"));
        });
    }
}
