package com.shoppit.user_service.service.impl;

import com.shoppit.user_service.config.JwtUtil;
import com.shoppit.user_service.dto.AuthRequest;
import com.shoppit.user_service.dto.AuthResponse;
import com.shoppit.user_service.service.AuthService;
import com.shoppit.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        return userService.findByEmail(authRequest.getEmail())
                .filter(user -> passwordEncoder.matches(authRequest.getPassword(), user.getPassword()))
                .map(user -> new AuthResponse(jwtUtil.generateToken(user.getEmail())))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
