package com.cloudnativeplayground.healthcare.repository;

import com.cloudnativeplayground.healthcare.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveAndFindUser() {
        User user = new User( "john_doe","password", "ROLE_PATIENT");
        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("john_doe", savedUser.getUsername());
    }
}
// Compare this snippet from src/test/java/com/cloudnativeplayground/healthcare/repository/UserRoleRepositoryTest.java: