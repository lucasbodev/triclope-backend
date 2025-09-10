package com.triclope.service;

import com.triclope.model.AuthUser;
import com.triclope.repository.AuthUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        
        return User.builder()
            .username(authUser.getUsername())
            .password(authUser.getPassword())
            .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + authUser.getRole())))
            .disabled(!authUser.isEnabled())
            .build();
    }

    public AuthUser authenticate(String username, String rawPassword) {
        return authUserRepository.findByUsername(username)
            .map(authUser -> {
                if (passwordEncoder.matches(rawPassword, authUser.getPassword())) {
                    return authUser;
                }
                throw new RuntimeException("Invalid credentials");
            })
            .orElseThrow(() -> new RuntimeException());
    }
}