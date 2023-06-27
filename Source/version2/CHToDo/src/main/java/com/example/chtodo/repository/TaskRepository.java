package com.example.chtodo.repository;

import com.example.chtodo.model.database.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<List<Task>> getAllByUserId(Integer userId);
}
