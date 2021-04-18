package com.sherstnyov.taskscheduler.web.mapper;

import com.sherstnyov.taskscheduler.jpa.domain.Task;
import com.sherstnyov.taskscheduler.web.dto.TaskModel;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskModel toModel(Task task) {
        return TaskModel
                .builder()
                .id(task.getId())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .userId(task.getUser().getId())
                .build();
    }
}
