package com.triclope.dto.response;

import java.util.UUID;

public record UserDto(UUID id, String firstName, String lastName) {
}