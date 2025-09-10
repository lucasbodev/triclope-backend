package com.triclope.repository;

import com.triclope.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, UUID> {
    
    Optional<AuthUser> findByUsername(String username);
    
    boolean existsByUsername(String username);
}