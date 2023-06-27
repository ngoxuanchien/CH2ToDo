package com.example.chtodo.service;

import com.example.chtodo.model.database.CHGroup;
import com.example.chtodo.model.database.CHUser;
import com.example.chtodo.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserService userService;

    public List<CHGroup> getAllGroup() {
        CHUser user = userService.getUser();
        return user.getGroupList();
    }

    public CHGroup updateGroup(CHGroup newGroup) {
        newGroup.setOwner(userService.getUser());
        return groupRepository.save(newGroup);
    }

    public CHGroup createGroup(CHGroup newGroup) {
        newGroup.setOwner(userService.getUser());
        return groupRepository.save(newGroup);
    }

    public CHGroup deleteGroup(Integer groupId) {
        CHGroup chGroup = groupRepository.findById(groupId).orElseThrow();
        groupRepository.delete(chGroup);
        return chGroup;
    }

    public List<CHGroup> getAllManageGroup() {
        CHUser user = userService.getUser();
        return groupRepository.findByOwner(user);
    }

    public CHGroup getGroup(Integer groupId) {
        return groupRepository.findById(groupId).orElseThrow();
    }

    public List<CHUser> getGroupUsers(Integer groupId) {
        CHGroup chGroup = groupRepository.findById(groupId).orElseThrow();
        return chGroup.getListUser();
    }
}
