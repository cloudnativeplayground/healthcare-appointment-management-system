package com.cloudnativeplayground.healthcare.service;

import com.cloudnativeplayground.healthcare.model.User;
import com.cloudnativeplayground.healthcare.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Assigns a role to a user.
     *
     * @param userId The ID of the user.
     * @param role   The role to be assigned.
     * @return true if role assignment is successful, false otherwise.
     */
    @Transactional
    public boolean assignRole(Long userId, String role) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setRole(role); // Assuming User entity has a 'role' field
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
// Compare this snippet from src/main/java/com/cloudnativeplayground/healthcare/service/AdminService.java: