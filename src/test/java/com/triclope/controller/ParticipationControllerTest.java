package com.triclope.controller;

import com.triclope.dto.response.ParticipationDto;
import com.triclope.dto.response.UserDto;
import com.triclope.service.ParticipationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ParticipationController.class)
class ParticipationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParticipationService participationService;

    @Test
    void getParticipationsByTriclopeId_ShouldReturnParticipations() throws Exception {
        // Given
        UUID triclopeId = UUID.fromString("550e8400-e29b-41d4-a716-446655440101");
        UserDto giver = new UserDto(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"), "John", "Doe");
        UserDto taker = new UserDto(UUID.fromString("550e8400-e29b-41d4-a716-446655440002"), "Jane", "Smith");
        
        List<ParticipationDto> expectedParticipations = Arrays.asList(
                new ParticipationDto(
                    UUID.fromString("550e8400-e29b-41d4-a716-446655440201"),
                    5,
                    LocalDateTime.now(),
                    triclopeId,
                    giver,
                    taker
                )
        );
        
        when(participationService.getByTriclopeId(triclopeId)).thenReturn(expectedParticipations);

        // When & Then
        mockMvc.perform(get("/api/v1/participation/triclope/{triclopeId}", triclopeId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].quantity").value(5))
                .andExpect(jsonPath("$[0].giver.firstName").value("John"))
                .andExpect(jsonPath("$[0].taker.firstName").value("Jane"));
    }
}