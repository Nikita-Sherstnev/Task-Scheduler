package com.sherstnyov.taskscheduler.web.dto;

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
    private List<Long> tasks;
}
