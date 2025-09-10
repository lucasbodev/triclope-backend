package com.triclope.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record ParticipationCreationRequest(
        @NotNull UUID triclopeId,
        @NotNull UUID giverId,
        @NotNull UUID takerId,
        @Positive int quantity
) {
    @Override
    public String toString() {
        return "ParticipationCreationRequest{" +
                "triclopeId=" + triclopeId +
                ", giverId=" + giverId +
                ", takerId=" + takerId +
                ", quantity=" + quantity +
                '}';
    }
}