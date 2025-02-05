package com.cloudnativeplayground.healthcare.service;

import com.cloudnativeplayground.healthcare.dto.AuthRequest;
import com.cloudnativeplayground.healthcare.dto.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);
    void logout();
    public AuthResponse authenticate(AuthRequest authRequest);
}
