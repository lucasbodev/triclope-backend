package com.triclope.controller;

import com.triclope.dto.request.RegisterUserRequest;
import com.triclope.service.AuthService;
import com.triclope.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final UserRegistrationService userRegistrationService;

    public AuthController(AuthService authService, UserRegistrationService userRegistrationService) {
        this.authService = authService;
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            String token = authService.authenticate(request.username(), request.password());
            return ResponseEntity.ok(Map.of(
                "access_token", token,
                "token_type", "Bearer",
                "expires_in", 86400
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid credentials"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserRequest request) {
        try {
            userRegistrationService.registerUser(request);
            return ResponseEntity.ok(Map.of("message", "User registered successfully"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshRequest request) {
        try {
            String refreshToken = authService.refreshToken(request.username());
            return ResponseEntity.ok(Map.of(
                "refresh_token", refreshToken,
                "token_type", "Bearer"
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid refresh request"));
        }
    }

    public record LoginRequest(String username, String password) {}
    public record RefreshRequest(String username) {}
}