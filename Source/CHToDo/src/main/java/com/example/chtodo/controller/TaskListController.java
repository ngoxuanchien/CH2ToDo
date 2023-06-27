package com.example.chtodo.controller;

import com.example.chtodo.model.database.Task;
import com.example.chtodo.model.database.TaskList;
import com.example.chtodo.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task_list")
public class TaskListController {
    private final TaskListService taskListService;

    @GetMapping
    public ResponseEntity<List<TaskList>> getAllTaskList() {
        return ResponseEntity.ok(taskListService.getAllTaskList());
    }

    @GetMapping("/{task_list_id}")
    public ResponseEntity<TaskList> getTaskList(@PathVariable Integer task_list_id) {
        return ResponseEntity.ok(taskListService.getTaskList(task_list_id));
    }

    @PostMapping
    public ResponseEntity<TaskList> createNewTaskList(@RequestBody TaskList taskList) {
        return ResponseEntity.ok(taskListService.createTaskList(taskList));
    }

    @PutMapping
    public ResponseEntity<TaskList> updateTaskList(@RequestBody TaskList taskList) {
        return ResponseEntity.ok(taskListService.createTaskList(taskList));
    }

    @DeleteMapping("/{task_list_id}")
    public ResponseEntity<TaskList> deleteTaskList(@PathVariable Integer task_list_id) {
        return ResponseEntity.ok(taskListService.deleteTaskList(task_list_id));
    }

}
