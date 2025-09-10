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

    public boolean authenticate(String username, String rawPassword) {
        return authUserRepository.findByUsername(username)
            .map(authUser -> {
                System.out.println("=== AUTHENTICATION DEBUG ===");
                System.out.println("Username: " + username);
                System.out.println("Raw password: " + rawPassword);
                System.out.println("Stored hash: " + authUser.getPassword());
                boolean matches = passwordEncoder.matches(rawPassword, authUser.getPassword());
                System.out.println("Password matches: " + matches);
                System.out.println("============================");
                return matches;
            })
            .orElse(false);
    }
}