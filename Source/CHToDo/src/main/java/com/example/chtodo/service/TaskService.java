package com.example.chtodo.service;

import com.example.chtodo.model.database.CHUser;
import com.example.chtodo.model.database.Status;
import com.example.chtodo.model.database.Task;
import com.example.chtodo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    private final UserService userService;
    public List<Task> getAllTask() {
        Integer userId = userService.getUserId();
        Optional<List<Task>> taskList = taskRepository.getAllByUserId(userId);

        return taskList.orElseGet(ArrayList::new);
    }

    public Task createTask(Task newTask) {
        CHUser user = userService.getUser();
        newTask.setUser(user);
        newTask.setStatus(Status.TODO);
        System.out.println(newTask);
        return taskRepository.save(newTask);
    }

    public Task updateTask(Task newTask) {
        return taskRepository.save(newTask);
    }

    public Task deleteTask(Integer taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        taskRepository.deleteById(taskId);
        return task;
    }

    public Task getTask(Integer taskId) {
        return taskRepository.findById(taskId).orElseThrow();
    }
}
