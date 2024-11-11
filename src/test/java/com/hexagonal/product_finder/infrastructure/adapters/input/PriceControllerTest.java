package com.hexagonal.product_finder.infrastructure.adapters.input;

import com.hexagonal.product_finder.application.port.input.GetPriceUseCase;
import com.hexagonal.product_finder.domain.exception.PriceNotFoundException;
import com.hexagonal.product_finder.domain.model.Price;
import com.hexagonal.product_finder.infrastructure.adapters.input.mapper.response.PriceResponseMapper;
import com.hexagonal.product_finder.infrastructure.dto.PriceDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(PriceController.class)
    public class PriceControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private GetPriceUseCase getPriceUseCase;

        @MockBean
        private PriceResponseMapper priceResponseMapper;

    @Test
    @DisplayName("Test 1: Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void testGetPriceAt10amOn14th() throws Exception {

        Price mockPrice = Price.builder()
                .id(1L)
                .brandId(1)
                .productId(35455L)
                .priceList(1)
                .priority(0)
                .price(new BigDecimal("35.5"))
                .curr("EUR")
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .build();

        when(getPriceUseCase.getPrice(1, 35455L, LocalDateTime.parse("2020-06-14T10:00:00")))
                .thenReturn(mockPrice);

        PriceDto mockPriceDto = new PriceDto();
        mockPriceDto.setPrice(new BigDecimal("35.5"));
        when(priceResponseMapper.map(any(Price.class), any(Optional.class)))
                .thenReturn(mockPriceDto);

        mockMvc.perform(get("/api/prices/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T10:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value("35.5"));
    }

    @Test
    @DisplayName("Test 2: Petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void testGetPriceAt4pmOn14th() throws Exception {

        Price mockPrice = Price.builder()
                .id(2L)
                .brandId(1)
                .productId(35455L)
                .priceList(2)
                .priority(1)
                .price(new BigDecimal("25.45"))
                .curr("EUR")
                .startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
                .endDate(LocalDateTime.parse("2020-06-14T18:30:00"))
                .build();

        when(getPriceUseCase.getPrice(1, 35455L, LocalDateTime.parse("2020-06-14T16:00:00")))
                .thenReturn(mockPrice);

        PriceDto mockPriceDto = new PriceDto();
        mockPriceDto.setPrice(new BigDecimal("25.45"));
        when(priceResponseMapper.map(any(Price.class), any(Optional.class)))
                .thenReturn(mockPriceDto);

        mockMvc.perform(get("/api/prices/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T16:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value("25.45"));
    }

    @Test
    @DisplayName("Test 3: Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void testGetPriceAt9pmOn14th() throws Exception {

        Price mockPrice = Price.builder()
                .id(1L)
                .brandId(1)
                .productId(35455L)
                .priceList(1)
                .priority(0)
                .price(new BigDecimal("35.5"))
                .curr("EUR")
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .build();

        when(getPriceUseCase.getPrice(1, 35455L, LocalDateTime.parse("2020-06-14T21:00:00")))
                .thenReturn(mockPrice);

        PriceDto mockPriceDto = new PriceDto();
        mockPriceDto.setPrice(new BigDecimal("35.5"));
        when(priceResponseMapper.map(any(Price.class), any(Optional.class)))
                .thenReturn(mockPriceDto);

        mockMvc.perform(get("/api/prices/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T21:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value("35.5"));
    }

    @Test
    @DisplayName("Test 4: Petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    public void testGetPriceAt10amOn15th() throws Exception {

        Price mockPrice = Price.builder()
                .id(3L)
                .brandId(1)
                .productId(35455L)
                .priceList(3)
                .priority(1)
                .price(new BigDecimal("30.5"))
                .curr("EUR")
                .startDate(LocalDateTime.parse("2020-06-15T00:00:00"))
                .endDate(LocalDateTime.parse("2020-06-15T11:00:00"))
                .build();

        when(getPriceUseCase.getPrice(1, 35455L, LocalDateTime.parse("2020-06-15T10:00:00")))
                .thenReturn(mockPrice);

        PriceDto mockPriceDto = new PriceDto();
        mockPriceDto.setPrice(new BigDecimal("30.5"));
        when(priceResponseMapper.map(any(Price.class), any(Optional.class)))
                .thenReturn(mockPriceDto);

        mockMvc.perform(get("/api/prices/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value("30.5"));
    }

    @Test
    @DisplayName("Test 5: Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    public void testGetPriceAt9pmOn16th() throws Exception {

        Price mockPrice = Price.builder()
                .id(4L)
                .brandId(1)
                .productId(35455L)
                .priceList(4)
                .priority(1)
                .price(new BigDecimal("38.95"))
                .curr("EUR")
                .startDate(LocalDateTime.parse("2020-06-15T16:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .build();

        when(getPriceUseCase.getPrice(1, 35455L, LocalDateTime.parse("2020-06-16T21:00:00")))
                .thenReturn(mockPrice);

        PriceDto mockPriceDto = new PriceDto();
        mockPriceDto.setPrice(new BigDecimal("38.95"));
        when(priceResponseMapper.map(any(Price.class), any(Optional.class)))
                .thenReturn(mockPriceDto);

        mockMvc.perform(get("/api/prices/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16T21:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value("38.95"));
    }


        @Test
        @DisplayName("testPriceNotFoundException")
        public void testPriceNotFoundException() throws Exception {
            // Mockear el caso para que lance la excepción
            when(getPriceUseCase.getPrice(anyInt(), anyLong(), any(LocalDateTime.class)))
                    .thenThrow(new PriceNotFoundException("Price not found for the provided parameters."));

            mockMvc.perform(get("/api/prices/price")
                            .param("brandId", "1")
                            .param("productId", "99999")
                            .param("applicationDate", "2020-06-14T10:00:00")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound()) // Espera un estado 404
                    .andExpect(jsonPath("$.error").value("Not Found")) // Verifica el campo "error"
                    .andExpect(jsonPath("$.message").value("Price not found for the provided parameters.")); // Verifica el campo "message"
        }


        @Test
        @DisplayName("testBadRequestException_MissingParameter - 400 - Bad Request")
        public void testBadRequestException_MissingParameter() throws Exception {
            mockMvc.perform(get("/api/prices/price")
                            .param("brandId", "1")
                            .param("productId", "35455")) // Falta applicationDate para lanzar MissingServletRequestParameterException
                    .andExpect(status().isBadRequest()) // Verifica que el estado sea 400
                    .andExpect(jsonPath("$.error").value("Bad Request")) // Verifica que el campo "error" sea "Bad Request"
                    .andExpect(jsonPath("$.message").value("Invalid or missing request parameters. Please check your request.")); // Verifica el campo "message"
        }

        // Prueba para 500 - Internal Server Error
        @Test
        @DisplayName("testInternalServerErrorException - 500 - Internal Server Error")
        public void testInternalServerErrorException() throws Exception {
            when(getPriceUseCase.getPrice(anyInt(), anyLong(), any(LocalDateTime.class)))
                    .thenThrow(new RuntimeException("Unexpected error"));

            mockMvc.perform(get("/api/prices/price")
                            .param("brandId", "1")
                            .param("productId", "35455")
                            .param("applicationDate", "2020-06-14T10:00:00"))
                    .andExpect(status().isInternalServerError())
                    .andExpect(jsonPath("$.error").value("Internal Server Error")) // Verifica que el campo "error" sea "Internal Server Error"
                    .andExpect(jsonPath("$.message").value("An unexpected error occurred. Please try again later.")); // Verifica el mensaje en "message"
        }

    }
