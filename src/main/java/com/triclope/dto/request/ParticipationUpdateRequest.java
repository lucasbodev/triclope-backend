package com.triclope.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record ParticipationUpdateRequest(
        @NotNull UUID id,
        @Positive int quantity
) {
    @Override
    public String toString() {
        return "ParticipationUpdateRequest{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}