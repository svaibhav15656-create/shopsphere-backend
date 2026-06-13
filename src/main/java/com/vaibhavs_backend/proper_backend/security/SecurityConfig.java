package com.vaibhavs_backend.proper_backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtService jwtservice;
    @Autowired
    private CustomUserDetailsService customuserdeatilsservice;
    
    @Bean
    public PasswordEncoder passwordencoder(){
        return null;
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        return null;
    }
    @Bean
    public  AuthenticationManager authenticationManager(AuthenticationConfiguration config){
        return null;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        return null;
    }
}
