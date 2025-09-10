package com.triclope.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "AUTH_USER", indexes = {
    @Index(name = "idx_auth_user_username", columnList = "username")
})
public class AuthUser {
    
    @Id
    @UuidGenerator
    @Column(name = "ID")
    private UUID id;
    
    @Column(name = "USERNAME", unique = true, nullable = false, length = 50)
    @NotBlank
    private String username;
    
    @Column(name = "PASSWORD", nullable = false)
    @NotBlank
    private String password;
    
    @Column(name = "ROLE", nullable = false, length = 20)
    @NotBlank
    private String role = "USER";
    
    @Column(name = "ENABLED", nullable = false)
    private boolean enabled = true;
    
    // Référence vers l'utilisateur business (optionnelle)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "triclope_user_id")
    private UserDb triclopeUser;
    
    // Constructeurs
    public AuthUser() {}
    
    public AuthUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public AuthUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    // Getters et Setters
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public UserDb getTriclopeUser() {
        return triclopeUser;
    }
    
    public void setTriclopeUser(UserDb triclopeUser) {
        this.triclopeUser = triclopeUser;
    }
}