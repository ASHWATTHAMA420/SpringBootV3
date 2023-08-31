package com.sample.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class LogoutService implements LogoutHandler {

    private Logger logger;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        if(authHeader == null && !authHeader.startsWith("Bearer ")) return;
        SecurityContextHolder.clearContext();
        logger.log(Level.INFO, "User security details cleared from system");
    }
}
