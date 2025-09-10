package com.triclope.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record TriclopeUpdateRequest(
        @NotNull UUID id,
        @NotBlank @Size(max = 100) String name, 
        byte[] logo, 
        @NotNull UUID createdBy
) {

    @Override
    public String toString() {
        return "TriclopeUpdateRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
