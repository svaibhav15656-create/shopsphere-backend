package com.vaibhavs_backend.proper_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vaibhavs_backend.proper_backend.dto.LoginRequest;
import com.vaibhavs_backend.proper_backend.dto.RegisterRequest;
import com.vaibhavs_backend.proper_backend.entity.Role;
import com.vaibhavs_backend.proper_backend.entity.User;
import com.vaibhavs_backend.proper_backend.repository.UserRepository;
import com.vaibhavs_backend.proper_backend.security.JwtService;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;


    public  String  register(RegisterRequest registerRequest){
        String email = registerRequest.getEmail();
        User existinguser = userRepository.findByEmail(email);
        if(existinguser != null){
            throw new RuntimeException("email already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        return jwtService.generateToken(user);
    }
    public String login(LoginRequest loginRequest){
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        User user = userRepository.findByEmail(email);
        return jwtService.generateToken(user);
        
    }
    
}
