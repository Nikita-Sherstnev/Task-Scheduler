package com.sherstnyov.taskscheduler.repos;

import com.sherstnyov.taskscheduler.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
