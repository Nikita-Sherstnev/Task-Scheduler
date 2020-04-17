package com.sherstnyov.taskscheduler.services;

import com.sherstnyov.taskscheduler.models.Task;
import com.sherstnyov.taskscheduler.repos.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
