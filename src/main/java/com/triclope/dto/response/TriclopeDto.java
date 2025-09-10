package com.triclope.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record TriclopeDto(UUID id, String name, LocalDateTime creationDate) {
}
