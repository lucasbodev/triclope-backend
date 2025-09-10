package com.triclope.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ParticipationDto(
    UUID id, 
    int quantity, 
    LocalDateTime createdAt,
    UUID triclopeId,
    UserDto giver,
    UserDto taker
) {
}
