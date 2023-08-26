package com.sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class DemoController {

    @GetMapping("/admin/helloAdmin")
    public ResponseEntity<String> helloAdmin() {
       return ResponseEntity.ok("This is admin page");
    }

    @GetMapping("/user/helloUser")
    public ResponseEntity<String> helloUser() {
        return ResponseEntity.ok("This is user page");
    }
}
