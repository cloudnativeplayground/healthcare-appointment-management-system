package com.cloudnativeplayground.healthcare.service;

import com.cloudnativeplayground.healthcare.model.User;
import com.cloudnativeplayground.healthcare.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void shouldReturnUserByUsername() {
        User user = new User(1L, "john_doe", "ROLE_PATIENT");
        when(userRepository.findByUsername("john_doe")).thenReturn(Optional.of(user));

        User foundUser = userService.findByUsername("john_doe");
        assertEquals("john_doe", foundUser.getUsername());
        verify(userRepository, times(1)).findByUsername("john_doe");
    }
}
