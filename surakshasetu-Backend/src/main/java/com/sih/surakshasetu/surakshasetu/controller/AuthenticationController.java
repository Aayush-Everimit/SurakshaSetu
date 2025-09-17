package com.sih.surakshasetu.controller;

import com.sih.surakshasetu.dto.LoginDTO;
import com.sih.surakshasetu.dto.RegistrationDTO;
import com.sih.surakshasetu.entity.TouristIdentity;
import com.sih.surakshasetu.repository.TouristIdentityRepository;
import com.sih.surakshasetu.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final TouristIdentityRepository touristRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TouristService touristService;

    public AuthenticationController(TouristIdentityRepository touristRepository,
                                    PasswordEncoder passwordEncoder,
                                    AuthenticationManager authenticationManager,
                                    TouristService touristService) {
        this.touristRepository = touristRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.touristService = touristService;
    }

    // Register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDTO registrationRequest) {

        Optional<TouristIdentity> existingUser = touristRepository.findByUsername(registrationRequest.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        existingUser = touristRepository.findByEmail(registrationRequest.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered");
        }

        TouristIdentity newTourist = new TouristIdentity();
        newTourist.setUsername(registrationRequest.getUsername());
        newTourist.setEmail(registrationRequest.getEmail());
        newTourist.setLocation(registrationRequest.getLocation());
        newTourist.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));

        touristRepository.save(newTourist);

        return ResponseEntity.ok("User registered successfully");
    }
    // login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        TouristIdentity currentUser = touristRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User not found after authentication"));

        return ResponseEntity.ok("Login successful");
    }

    // Logout
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logged out successfully");
    }
}
