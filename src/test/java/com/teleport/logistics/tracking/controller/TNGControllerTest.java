package com.teleport.logistics.tracking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teleport.logistics.tracking.dto.TrackingNumberReq;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TNGControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void returnsValidTrackingNumberForValidRequest() throws Exception {
        TrackingNumberReq validRequest = TrackingNumberReq.builder()
                .origin_country_id("MY")
                .destination_country_id("SG")
                .weight(new BigDecimal("1.234"))
                .created_at(ZonedDateTime.parse("2023-01-01T12:00:00.0000000+00:00"))
                .customer_id(UUID.randomUUID())
                .customer_name("REDBOX LOGISTICS")
                .customer_slug("redbox-logistics")
                .build();

        mockMvc.perform(post("/api/next-tracking-number")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tracking_number").isNotEmpty())
                .andExpect(jsonPath("$.created_at").isNotEmpty());
    }

    @Test
    void returnsBadRequestForInvalidRequest() throws Exception {
        TrackingNumberReq invalidRequest = new TrackingNumberReq();

        mockMvc.perform(post("/api/next-tracking-number")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
    }
}