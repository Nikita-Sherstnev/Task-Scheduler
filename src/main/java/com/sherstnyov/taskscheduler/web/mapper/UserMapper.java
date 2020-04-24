package com.sherstnyov.taskscheduler.web.mapper;

import com.sherstnyov.taskscheduler.jpa.domain.Task;
import com.sherstnyov.taskscheduler.jpa.domain.User;
import com.sherstnyov.taskscheduler.web.dto.UserModel;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserModel toModel(User user) {
    return UserModel
      .builder()
      .id(user.getId())
      .username(user.getUsername())
      .email(user.getEmail())
      .tasks(
        user.getTasks().stream().map(Task::getId).collect(Collectors.toList())
      )
      .build();
  }
}
