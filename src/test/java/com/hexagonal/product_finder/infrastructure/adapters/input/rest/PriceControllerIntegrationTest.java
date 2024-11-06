package com.hexagonal.product_finder.infrastructure.adapters.input.rest;

import com.hexagonal.product_finder.ProductFinderApplication;
import com.hexagonal.product_finder.domain.model.Price;
import com.hexagonal.product_finder.infrastructure.adapters.output.PriceRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(classes = ProductFinderApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Integration Test: Get Price at Specific Time")
    public void testGetPriceAtSpecificTime() throws Exception {
        mockMvc.perform(get("/api/prices/price")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14T15:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value("25.45"));
    }

    @Test
    @DisplayName("Integration Test: Price Not Found")
    public void testPriceNotFound() throws Exception {
        mockMvc.perform(get("/api/prices/price")
                        .param("brandId", "1")
                        .param("productId", "99999")
                        .param("applicationDate", "2020-06-15T00:00:00")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Price not found for the provided parameters."));
    }
}