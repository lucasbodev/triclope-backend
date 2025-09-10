package com.triclope.controller;

import com.triclope.dto.response.UserDto;
import com.triclope.service.TriclopeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TriclopeController.class)
class TriclopeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TriclopeService triclopeService;

    @MockBean
    private com.triclope.service.ParticipationService participationService;

    @Test
    void getUsersByTriclopeId_ShouldReturnUsers() throws Exception {
        // Given
        UUID triclopeId = UUID.fromString("550e8400-e29b-41d4-a716-446655440101");
        List<UserDto> expectedUsers = Arrays.asList(
                new UserDto(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"), "John", "Doe"),
                new UserDto(UUID.fromString("550e8400-e29b-41d4-a716-446655440002"), "Jane", "Smith")
        );
        
        when(triclopeService.getUsersByTriclopeId(triclopeId)).thenReturn(expectedUsers);

        // When & Then
        mockMvc.perform(get("/api/v1/triclope/{triclopeId}/user", triclopeId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value("550e8400-e29b-41d4-a716-446655440001"))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[1].id").value("550e8400-e29b-41d4-a716-446655440002"))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].lastName").value("Smith"));
    }
}