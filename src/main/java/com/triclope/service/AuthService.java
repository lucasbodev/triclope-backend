package com.triclope.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthService(JwtService jwtService, UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public String authenticate(String username, String password) {
        if (userDetailsService.authenticate(username, password)) {
            return jwtService.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }

    public String refreshToken(String username) {
        return jwtService.generateRefreshToken(username);
    }
}