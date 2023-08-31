package com.sample.service;

import com.sample.jwt.JwtService;
import com.sample.model.User;
import com.sample.payload.request.LoginRequest;
import com.sample.payload.request.SignupRequest;
import com.sample.payload.response.AuthResponse;
import com.sample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public String token = null;

    public AuthResponse login(LoginRequest request) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    User user = userRepo.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found with email = " + request.getEmail()));
    token = jwtService.generateToken(user);
    return AuthResponse.builder().token(token).build();
    }

    public AuthResponse signup(SignupRequest request) {
    User user = new User(request.getFirstname(), request.getLastname(), request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getRole());
    userRepo.save(user);
    token = jwtService.generateToken(user);
    return AuthResponse.builder().token(token).build();
    }
}
