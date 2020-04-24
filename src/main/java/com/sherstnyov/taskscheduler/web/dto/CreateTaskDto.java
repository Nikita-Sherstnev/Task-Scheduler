package com.sherstnyov.taskscheduler.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
public class CreateTaskDto {

    @NotNull
    @Length(max = 4096)
    private String description;

    @Nullable
    private Instant deadline;

    @NotNull
    private Long userId;
}
