package com.triclope.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddMemberRequest(
        @NotNull UUID userId
) {
    @Override
    public String toString() {
        return "AddMemberRequest{" +
                "userId=" + userId +
                '}';
    }
}