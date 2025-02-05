package com.cloudnativeplayground.healthcare.controller;

import com.cloudnativeplayground.healthcare.dto.AuthRequest;
import com.cloudnativeplayground.healthcare.dto.AuthResponse;
import com.cloudnativeplayground.healthcare.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.authenticate(authRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        authService.logout();
        return ResponseEntity.ok("User logged out successfully.");
    }
}
