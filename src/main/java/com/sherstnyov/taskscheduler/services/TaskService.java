package com.sherstnyov.taskscheduler.services;

import com.sherstnyov.taskscheduler.jpa.domain.Task;
import com.sherstnyov.taskscheduler.jpa.domain.User;
import com.sherstnyov.taskscheduler.jpa.repository.TaskRepository;
import com.sherstnyov.taskscheduler.web.dto.CreateTaskDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final NotificationService notificationService;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task save(CreateTaskDto taskDto) {
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setDeadline(taskDto.getDeadline());
        task.setUser(userService.getById(taskDto.getUserId()));
        notificationService.setNews("Task added!");
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
