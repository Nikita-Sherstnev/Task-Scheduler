package com.sherstnyov.taskscheduler.repos;

import com.sherstnyov.taskscheduler.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
