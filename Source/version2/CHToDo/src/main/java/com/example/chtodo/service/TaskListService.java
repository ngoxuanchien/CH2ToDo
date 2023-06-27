package com.example.chtodo.service;

import com.example.chtodo.model.database.CHUser;
import com.example.chtodo.model.database.TaskList;
import com.example.chtodo.repository.TaskListRepository;
import com.example.chtodo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskListService {
    private final TaskListRepository taskListRepository;
    private final UserService userService;
    public TaskList createTaskList(TaskList newTaskList) {
        newTaskList.setUser(userService.getUser());
        return taskListRepository.save(newTaskList);
    }

    public TaskList updateTaskList(TaskList newTaskList) {
        return taskListRepository.save(newTaskList);
    }

    public TaskList deleteTaskList(Integer taskListId) {
        TaskList taskList = taskListRepository.findById(taskListId).orElseThrow();
        taskListRepository.delete(taskList);
        return taskList;
    }

    public TaskList getTaskList(Integer taskListId) {
        return taskListRepository.findById(taskListId).orElseThrow();
    }

    public List<TaskList> getAllTaskList() {
        CHUser chUser = userService.getUser();
        return chUser.getTaskList();
    }
}
