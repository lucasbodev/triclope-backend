package com.triclope.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TriclopeCreationRequest(@NotBlank String name, @NotNull byte[] logo, @NotBlank String createdBy) {

    @Override
    public String toString() {
        return "TriclopeCreationRequest{" +
                "name='" + name + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}

