package com.shoppit.user_service.service.impl;

import com.shoppit.user_service.config.JwtUtil;
import com.shoppit.user_service.dto.AuthRequest;
import com.shoppit.user_service.dto.AuthResponse;
import com.shoppit.user_service.entity.User;
import com.shoppit.user_service.service.AuthService;
import com.shoppit.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        return userService.findByEmail(authRequest.getEmail())
                .filter(user -> passwordEncoder.matches(authRequest.getPassword(), user.getPassword()))
                .map(user -> new AuthResponse(jwtUtil.generateToken(user.getEmail())))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
