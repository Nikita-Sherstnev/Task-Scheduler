package com.sherstnyov.taskscheduler.services;

import com.sherstnyov.taskscheduler.jpa.domain.User;
import com.sherstnyov.taskscheduler.jpa.repository.UserRepository;
import com.sherstnyov.taskscheduler.web.dto.CreateUserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User save(CreateUserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
