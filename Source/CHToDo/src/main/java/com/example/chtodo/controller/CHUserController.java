package com.example.chtodo.controller;

import com.example.chtodo.model.database.CHUser;
import com.example.chtodo.model.database.Task;
import com.example.chtodo.service.TaskService;
import com.example.chtodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class CHUserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<CHUser> updateUser(@RequestBody CHUser newUser) {
        return ResponseEntity.ok(userService.updateUser(newUser));
    }

    @GetMapping
    public ResponseEntity<CHUser> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }


}
