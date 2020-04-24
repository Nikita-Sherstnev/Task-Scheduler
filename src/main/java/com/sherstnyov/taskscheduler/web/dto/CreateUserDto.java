package com.sherstnyov.taskscheduler.web.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {
  @NotNull
  private String username;

  @NotNull
  private String email;
}
