package com.sherstnyov.taskscheduler.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserDto {
    @NotNull
    private String username;

    @NotNull
    private String email;
}
