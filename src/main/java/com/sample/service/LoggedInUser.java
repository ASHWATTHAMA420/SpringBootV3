package com.sample.service;

import com.sample.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggedInUser {

    public static User getCurrentUser() {
        User user =  ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        log.info("getCurrentUser User = " + user.toString());
        return user;
    }

    public static String getEmailOfLoggedInUser() {
        String email =  getCurrentUser().getEmail();
        log.info("getEmailOfLoggedInUser Email = " + email);
        return email;
    }
}
