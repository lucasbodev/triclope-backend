package com.triclope.service;

import com.triclope.model.AuthUser;
import com.triclope.model.UserDb;
import com.triclope.repository.AuthUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserService {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthUserService(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthUser createAuthUser(String username, String password) {
        return createAuthUser(username, password, "USER");
    }

    public AuthUser createAuthUser(String username, String password, String role) {
        if (authUserRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists: " + username);
        }

        AuthUser authUser = new AuthUser();
        authUser.setUsername(username);
        authUser.setPassword(passwordEncoder.encode(password));
        authUser.setRole(role);
        authUser.setEnabled(true);

        return authUserRepository.save(authUser);
    }

    public Optional<AuthUser> findByUsername(String username) {
        return authUserRepository.findByUsername(username);
    }

    public void linkTriclopeUser(String username, UserDb triclopeUser) {
        AuthUser authUser = authUserRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Auth user not found: " + username));
        
        authUser.setTriclopeUser(triclopeUser);
        authUserRepository.save(authUser);
    }

    public void enableUser(String username) {
        AuthUser authUser = authUserRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Auth user not found: " + username));
        
        authUser.setEnabled(true);
        authUserRepository.save(authUser);
    }

    public void disableUser(String username) {
        AuthUser authUser = authUserRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Auth user not found: " + username));
        
        authUser.setEnabled(false);
        authUserRepository.save(authUser);
    }
}