package com.sherstnyov.taskscheduler.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TaskModel {
    private Long id;
    private String description;
    private Instant deadline;
    private Long userId;

    public TaskModel() {

    }
}
