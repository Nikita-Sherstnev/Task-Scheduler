package com.sherstnyov.taskscheduler.jpa.repository;

import com.sherstnyov.taskscheduler.jpa.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityNotFoundException;

//Загружаем только конфигурацию, относящуюся к JPA
//В конце каждого теста происходит roll back
@DataJpaTest
//Используем основную БД для тестов
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryIntegrationTest {
    @Autowired
    private UserRepository userRepository;

    private static final Long USER_ID = 1L;
    private static final String USERNAME = "Tom";
    private static final String USER_EMAIL = "tom@tom.com";
    private static final String USER_PASSWORD = "password";

    @BeforeEach
    public void setUp() {
        userRepository.save(createUser());
    }

    @Test
    public void saveUser() {
        Assert.assertNotNull(userRepository.findUserByEmail(USER_EMAIL));
    }

    @Test
    public void findUserByEmail() {
        User user = userRepository.findUserByEmail(USER_EMAIL)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Assert.assertEquals(createUser().getEmail(), user.getEmail());
        Assert.assertEquals(createUser().getUsername(), user.getUsername());
    }

    @Test
    public void updateUser() {
        User user = userRepository.findUserByEmail(USER_EMAIL)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setUsername("Carl");
        Assert.assertEquals("Carl", userRepository.findUserByEmail(USER_EMAIL)
                .map(User::getUsername).orElse(null));
    }

    @Test
    public void deleteUser() {
        userRepository.deleteUserByEmail(USER_EMAIL);
        Assert.assertNull(userRepository.findUserByEmail(USER_EMAIL).orElse(null));
    }

    private User createUser() {
        User user = new User();
        user.setId(USER_ID);
        user.setUsername(USERNAME);
        user.setPassword(USER_PASSWORD);
        user.setEmail(USER_EMAIL);
        return user;
    }
}
