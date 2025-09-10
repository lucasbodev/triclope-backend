package com.triclope.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(
    @NotBlank
    @Size(min = 3, max = 50)
    String username,
    
    @NotBlank
    @Size(min = 6, max = 100)
    String password,
    
    @NotBlank
    @Size(max = 50)
    String firstName,
    
    @NotBlank
    @Size(max = 50)
    String lastName,
    
    @NotBlank
    @Email
    String email
) {}