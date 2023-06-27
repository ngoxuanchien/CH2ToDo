package com.example.chtodo.controller;

import com.example.chtodo.model.database.Task;
import com.example.chtodo.service.TaskService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Integer taskId) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task newTask) {
        return ResponseEntity.ok(taskService.updateTask(newTask));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) {
        return ResponseEntity.ok(taskService.createTask(newTask));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable Integer taskId) {
        return ResponseEntity.ok(taskService.deleteTask(taskId));
    }

}
