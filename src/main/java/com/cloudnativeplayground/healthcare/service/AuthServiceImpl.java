package com.cloudnativeplayground.healthcare.service;

import com.cloudnativeplayground.healthcare.dto.AuthRequest;
import com.cloudnativeplayground.healthcare.dto.AuthResponse;
import com.cloudnativeplayground.healthcare.model.User;
import com.cloudnativeplayground.healthcare.repository.UserRepository;
import com.cloudnativeplayground.healthcare.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserDetailsService userDetailsService,
                           JwtTokenProvider jwtTokenProvider,
                           UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenProvider.generateToken(userDetails);

        User user = userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new AuthResponse(user.getId(), user.getUsername(), token);
    }

    @Override
    public void logout() {
        // No need to invalidate JWT since it's stateless, but we could implement a token blacklist mechanism here
    }

    /**
     * Authenticates a user and generates a JWT token.
     *
     * @param authRequest Authentication request containing username and password.
     * @return AuthResponse with JWT token.
     */
    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(userDetails);

        return new AuthResponse(userDetails.getUsername(),token);
    }
}
