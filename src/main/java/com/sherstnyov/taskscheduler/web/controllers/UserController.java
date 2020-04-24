package com.sherstnyov.taskscheduler.web.controllers;

import com.sherstnyov.taskscheduler.jpa.domain.User;
import com.sherstnyov.taskscheduler.services.UserService;
import com.sherstnyov.taskscheduler.web.dto.CreateUserDto;
import com.sherstnyov.taskscheduler.web.dto.UserModel;
import com.sherstnyov.taskscheduler.web.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
  private final UserService userService;

  private final UserMapper userMapper;

  @GetMapping
  public ResponseEntity<List<UserModel>> getUsers() {
    List<UserModel> userModelList = userService.getAll().stream()
    .map(user -> userMapper.toModel(user))
    .collect(Collectors.toList());
    return ResponseEntity.ok(userModelList);
  }

  @PostMapping
  public ResponseEntity<UserModel> createTask(
    @Valid @RequestBody CreateUserDto userDto
  ) {
    User user = userService.save(userDto);
    UserModel userModel = userMapper.toModel(user);
    return ResponseEntity.ok(userModel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    userService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
