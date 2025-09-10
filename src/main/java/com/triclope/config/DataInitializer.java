package com.triclope.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Générer et afficher le hash pour "password"
        String password = "password";
        String hash = passwordEncoder.encode(password);
        System.out.println("=== PASSWORD HASH DEBUG ===");
        System.out.println("Password: " + password);
        System.out.println("Generated Hash: " + hash);
        
        // Tester le hash existant dans data.sql
        String existingHash = "$2a$10$CwTycUXWue0Thq9StjUM0uBUcAsqx4Hllls2FkEqRBUtzHyi.jjS6";
        boolean matches = passwordEncoder.matches(password, existingHash);
        System.out.println("Current hash matches 'password': " + matches);
        
        // Générer plusieurs hashs pour être sûr
        System.out.println("--- Additional hashes for 'password' ---");
        for (int i = 0; i < 3; i++) {
            String newHash = passwordEncoder.encode(password);
            boolean testMatch = passwordEncoder.matches(password, newHash);
            System.out.println("Hash " + (i+1) + ": " + newHash + " (matches: " + testMatch + ")");
        }
        System.out.println("===========================");
    }
}