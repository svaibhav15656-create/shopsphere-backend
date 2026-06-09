package com.vaibhavs_backend.proper_backend.security;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.vaibhavs_backend.proper_backend.entity.User;

@Service
public class JwtService {
    @Value("${jwt.secret}")    
    private String secretKey;
    public String generateToken(User user) {
    // leave empty for now
    return null;
}

public String extractEmail(String token) {
    return null;
}

public boolean isTokenValid(String token, UserDetails userDetails) {
    return false;
}

}
