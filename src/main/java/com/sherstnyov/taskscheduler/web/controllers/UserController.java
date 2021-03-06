package com.sherstnyov.taskscheduler.web.controllers;

import com.sherstnyov.taskscheduler.jpa.domain.User;
import com.sherstnyov.taskscheduler.services.UserService;
import com.sherstnyov.taskscheduler.web.dto.CreateUserDto;
import com.sherstnyov.taskscheduler.web.dto.UserModel;
import com.sherstnyov.taskscheduler.web.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAll() {
        List<UserModel> userModelList = userService
                .getAll()
                .stream()
                .map(userMapper::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userModelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        UserModel userModel = userMapper.toModel(user);
        return ResponseEntity.ok(userModel);
    }

    @PostMapping
    public ResponseEntity<UserModel> create(
            @Valid @RequestBody CreateUserDto userDto
    ) {
        User user = userService.save(userDto);
        UserModel userModel = userMapper.toModel(user);
        return ResponseEntity.ok(userModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
