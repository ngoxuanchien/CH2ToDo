package com.example.chtodo.repository;

import com.example.chtodo.model.database.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Integer> {
}
