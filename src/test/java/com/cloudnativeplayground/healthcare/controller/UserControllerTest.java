package com.cloudnativeplayground.healthcare.controller;

import com.cloudnativeplayground.healthcare.model.User;
import com.cloudnativeplayground.healthcare.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserService.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldGetUserByUsername() throws Exception {
        User user = new User(1L, "john_doe", "ROLE_PATIENT");
        Mockito.when(userService.findByUsername("john_doe")).thenReturn(user);

        mockMvc.perform(get("/api/users/john_doe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("john_doe"))
                .andExpect(jsonPath("$.role").value("ROLE_PATIENT"));
    }
}
