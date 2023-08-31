package com.sample.service;

import com.sample.jwt.JwtService;
import com.sample.model.User;
import com.sample.payload.response.UserResponse;
import com.sample.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.LogManager;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtService jwtService;

    public UserResponse getUserDetails() {
        String email = LoggedInUser.getEmailOfLoggedInUser();
        log.info("Logged in User email = " + email);
        if(email.isEmpty()) throw new UsernameNotFoundException("User not found with username = "+ email);
        User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username not found = " + email));
        UserResponse userResponse = new UserResponse(user.getFirstname(), user.getLastname(), user.getEmail(), user.getRole());
        return userResponse;
    }

}

