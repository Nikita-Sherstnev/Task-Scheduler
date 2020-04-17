package com.sherstnyov.taskscheduler.controllers;

import com.sherstnyov.taskscheduler.models.Task;
import com.sherstnyov.taskscheduler.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    List<Task> getTasks() {
        return taskService.getAll();
    }

    @PostMapping
    ResponseEntity<Task> createTask(@Valid @RequestBody Task task) throws URISyntaxException {
        Task result = taskService.save(task);
        return ResponseEntity.created(new URI("/tasks" + result.getId())).body(result);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
