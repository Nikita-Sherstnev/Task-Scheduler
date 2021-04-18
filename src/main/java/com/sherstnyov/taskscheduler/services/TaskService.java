package com.sherstnyov.taskscheduler.services;

import com.sherstnyov.taskscheduler.jpa.domain.Task;
import com.sherstnyov.taskscheduler.jpa.domain.User;
import com.sherstnyov.taskscheduler.jpa.repository.TaskRepository;
import com.sherstnyov.taskscheduler.web.dto.CreateTaskDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
    }

    @Transactional
    public Task save(CreateTaskDto taskDto) {
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setDeadline(taskDto.getDeadline());
        task.setUser(userService.getById(taskDto.getUserId()));
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
