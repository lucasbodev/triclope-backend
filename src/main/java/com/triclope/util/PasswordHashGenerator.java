package com.triclope.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password";
        String hash = encoder.encode(password);
        System.out.println("Hash for 'password': " + hash);
        
        // Vérification
        boolean matches = encoder.matches(password, hash);
        System.out.println("Verification: " + matches);
    }
}