package com.example.chtodo.controller;

import com.example.chtodo.model.database.CHGroup;
import com.example.chtodo.model.database.CHUser;
import com.example.chtodo.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<CHGroup>> getAllGroup() {
        return ResponseEntity.ok(groupService.getAllGroup());
    }

    @GetMapping("{group_id}")
    public ResponseEntity<CHGroup> getGroup(@PathVariable Integer group_id) {
        return ResponseEntity.ok(groupService.getGroup(group_id));
    }

    @GetMapping("/manage_group")
    public ResponseEntity<List<CHGroup>> getAllManageGroup() {
        return ResponseEntity.ok(groupService.getAllManageGroup());
    }

    @GetMapping("/group_users/{group_id}")
    public ResponseEntity<List<CHUser>> getGroupUsers(@PathVariable Integer group_id) {
        return ResponseEntity.ok(groupService.getGroupUsers(group_id));
    }

    @PostMapping
    public ResponseEntity<CHGroup> createGroup(@RequestBody CHGroup newGroup) {
        return ResponseEntity.ok(groupService.createGroup(newGroup));
    }
    @PutMapping
    public ResponseEntity<CHGroup> updateGroup(@RequestBody CHGroup newGroup) {
        return ResponseEntity.ok(groupService.updateGroup(newGroup));
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<CHGroup> deleteGroup(@PathVariable Integer groupId) {
        return ResponseEntity.ok(groupService.deleteGroup(groupId));
    }
}
