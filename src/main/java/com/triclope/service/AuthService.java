package com.triclope.service;

import com.triclope.model.AuthUser;
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
        AuthUser authenticate = userDetailsService.authenticate(username, password);
        if (authenticate != null) {
            return jwtService.generateToken(authenticate);
        }
        throw new RuntimeException("Invalid credentials");
    }

    public String refreshToken(String username) {
        return jwtService.generateRefreshToken(username);
    }
}