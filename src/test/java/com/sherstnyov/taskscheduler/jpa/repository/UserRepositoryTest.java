package com.sherstnyov.taskscheduler.jpa.repository;

import com.sherstnyov.taskscheduler.jpa.domain.User;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AllArgsConstructor
public class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    public void saveUser() {
        userRepository.save(new User());
    }
}
