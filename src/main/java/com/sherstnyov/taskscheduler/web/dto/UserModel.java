package com.sherstnyov.taskscheduler.web.dto;

import com.sherstnyov.taskscheduler.jpa.domain.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserModel {

    private Long id;
    private String username;
    private String email;
    private List<Task> tasks;
}
