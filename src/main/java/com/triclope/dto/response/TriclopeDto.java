package com.triclope.dto.response;


import java.time.LocalDateTime;

public record TriclopeDto(String id, String name, LocalDateTime creationDate) {
}
