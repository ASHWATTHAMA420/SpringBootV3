package com.sample.service;

import com.sample.model.User;
import com.sample.payload.request.SignupRequest;
import com.sample.payload.response.UserResponse;
import com.sample.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AdminService {

    @Autowired
    private UserRepo userRepo;

    public List<UserResponse> adminGetAllUsers() {
        List<User> allUsers = userRepo.findAll();
        UserResponse usersResponses = new UserResponse();
        List<UserResponse> adminAllUsersResponses = new ArrayList<>();
        for (User user : allUsers) {
            usersResponses.setFirstname(user.getFirstname());
            usersResponses.setLastname(user.getLastname());
            usersResponses.setEmail(user.getEmail());
            usersResponses.setRole(user.getRole());
            adminAllUsersResponses.add(usersResponses);
        }
        return adminAllUsersResponses;
    }

    public UserResponse addNewUser(SignupRequest request) {
        User user = new User(request.getFirstname(), request.getLastname(), request.getEmail(), request.getPassword(), request.getRole());
        UserResponse userResponse = new UserResponse(request.getFirstname(), request.getLastname(), request.getEmail(), request.getRole());
        userRepo.save(user);
        return userResponse;
    }

    public void deleteUser(String email) {
        User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email = " + email));
        userRepo.delete(user);
    }

}
