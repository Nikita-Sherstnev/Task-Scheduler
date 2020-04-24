package com.sherstnyov.taskscheduler.web.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserModel {
  private Long id;
  private String username;
  private String email;
  private List<Long> tasks;
}
