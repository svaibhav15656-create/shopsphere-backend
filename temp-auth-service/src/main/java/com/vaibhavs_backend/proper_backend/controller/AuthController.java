package com.vaibhavs_backend.proper_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhavs_backend.proper_backend.dto.LoginRequest;
import com.vaibhavs_backend.proper_backend.dto.RegisterRequest;
import com.vaibhavs_backend.proper_backend.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authseservice;
    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody RegisterRequest request) {
        String token = authseservice.register(request);
        return ResponseEntity.ok("access token is"+token);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
         String token = authseservice.login(request);
    return ResponseEntity.ok("access token is"+token);

    }
    
}