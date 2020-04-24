package com.sherstnyov.taskscheduler.web.controllers;

import com.sherstnyov.taskscheduler.jpa.domain.Task;
import com.sherstnyov.taskscheduler.services.TaskService;
import com.sherstnyov.taskscheduler.web.dto.CreateTaskDto;
import com.sherstnyov.taskscheduler.web.dto.TaskModel;
import com.sherstnyov.taskscheduler.web.mapper.TaskMapper;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
  private final TaskService taskService;

  private final TaskMapper taskMapper;

  @GetMapping
  public ResponseEntity<List<TaskModel>> getTasks() {
    List<TaskModel> taskModelList = taskService.getAll().stream()
    .map(task -> taskMapper.toModel(task))
    .collect(Collectors.toList());
    return ResponseEntity.ok(taskModelList);
  }

  @PostMapping
  public ResponseEntity<TaskModel> createTask(
    @Valid @RequestBody CreateTaskDto taskDto
  ) {
    Task task = taskService.save(taskDto);
    TaskModel taskModel = taskMapper.toModel(task);
    return ResponseEntity.ok(taskModel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTask(@PathVariable Long id) {
    taskService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
