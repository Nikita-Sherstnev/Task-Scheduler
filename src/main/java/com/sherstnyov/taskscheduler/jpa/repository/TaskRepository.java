package com.sherstnyov.taskscheduler.jpa.repository;

import com.sherstnyov.taskscheduler.jpa.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
