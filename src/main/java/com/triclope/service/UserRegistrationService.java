package com.triclope.service;

import com.triclope.dto.request.RegisterUserRequest;
import com.triclope.model.AuthUser;
import com.triclope.model.UserDb;
import com.triclope.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRegistrationService {

    private final AuthUserService authUserService;
    private final UserRepository userRepository;

    public UserRegistrationService(AuthUserService authUserService, UserRepository userRepository) {
        this.authUserService = authUserService;
        this.userRepository = userRepository;
    }

    @Transactional
    public void registerUser(RegisterUserRequest request) {
        // Vérifier si l'email existe déjà
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists: " + request.email());
        }

        // Créer l'utilisateur business
        UserDb triclopeUser = new UserDb();
        triclopeUser.setFirstName(request.firstName());
        triclopeUser.setLastName(request.lastName());
        triclopeUser.setEmail(request.email());
        
        UserDb savedTriclopeUser = userRepository.save(triclopeUser);

        // Créer l'utilisateur d'authentification
        AuthUser authUser = authUserService.createAuthUser(
            request.username(), 
            request.password()
        );

        // Lier les deux entités
        authUserService.linkTriclopeUser(request.username(), savedTriclopeUser);
    }
}