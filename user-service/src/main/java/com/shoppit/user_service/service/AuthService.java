package com.shoppit.user_service.service;

import com.shoppit.user_service.dto.AuthRequest;
import com.shoppit.user_service.dto.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest authRequest);
}
