package com.sample.controller;

import com.sample.model.User;
import com.sample.payload.request.SignupRequest;
import com.sample.payload.response.UserResponse;
import com.sample.repo.UserRepo;
import com.sample.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/auth/admin")
@RestController
public class AdminController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AdminService adminService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(adminService.adminGetAllUsers());
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> addNewUser(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(adminService.addNewUser(request));
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(String email) {
        adminService.deleteUser(email);
    }


}
