package com.sherstnyov.taskscheduler.web.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskModel {
  private Long id;
  private String description;
  private Instant deadline;
  private Long userId;
}
