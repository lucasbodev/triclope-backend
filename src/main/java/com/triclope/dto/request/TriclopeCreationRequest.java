package com.triclope.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record TriclopeCreationRequest(
        @NotBlank @Size(max = 100) String name, 
        byte[] logo
) {

    @Override
    public String toString() {
        return "TriclopeCreationRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}

