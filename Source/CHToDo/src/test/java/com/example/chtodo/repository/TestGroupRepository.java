package com.example.chtodo.repository;

import com.example.chtodo.model.CHGroup;
import com.example.chtodo.model.CHUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestGroupRepository {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void testAddGroup() {
        Integer id = 1;
        CHUser chUser = userRepository.findById(id).orElse(null);

        CHGroup newGroup = CHGroup.builder()
                .owner(chUser)
                .name("Group 1")
                .build();

        groupRepository.save(newGroup);
//        System.out.println(newGroup);
//
//
//
//        CHUser newUser = userRepository.findById(2).orElse(null);
//        if (newUser != null) {
//        System.out.println(newUser);
//
//        CHUser_Group chUserGroup = CHUser_Group.builder()
//                .user(newUser)
//                .group(newGroup)
//                .build();
//
//            chUserGroupRepository.save(chUserGroup);
//            newGroup.getListUser().add(newUser);
//            newUser.getGroupList().add(newGroup);
//            groupRepository.save(newGroup);
//            userRepository.save(newUser);
//
//            System.out.println(newGroup);
//
//            System.out.println(newUser.getGroupList());
//            System.out.println(newGroup.getListUser());

//        }




    }

    @Test
    @Transactional
    public void testAddUser() throws JsonProcessingException {
        CHUser user = userRepository.findById(2).orElse(null);
        CHGroup group = groupRepository.findById(11).orElse(null);

        if (user != null && group != null) {
//            CHUser_Group chUserGroup = CHUser_Group.builder()
//                .user(user)
//                .group(group)
//                .build();

            group.getListUser().add(user);
            user.getGroupList().add(group);

            userRepository.save(user);
            groupRepository.save(group);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(group.getListUser());
            System.out.println(jsonString);

//            chUserGroupRepository.save(chUserGroup);
//            System.out.println(user.getGroupList());
//            System.out.println(group.getListUser());
        }
    }
}
