package com.triclope.dto.response;

public record AuthResponse(
        String token,
        String type,
        UserDto user
) {
    public AuthResponse(String token, UserDto user) {
        this(token, "Bearer", user);
    }
}