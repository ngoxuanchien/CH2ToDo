package com.example.chtodo.repository;

import com.example.chtodo.model.CHUser;
import com.example.chtodo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestUserRepository {

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
    public void testAddUser1() {
        CHUser newUser = CHUser.builder()
                .fullname("Ngô Xuân Chiến")
                .birthday(Date.valueOf("2002-01-17"))
                .email("ngoxuanchien9a@gmail.com")
                .password("password")
                .mobilePhone("0963441360")
                .address("Phú Yên")
                .build();

        userRepository.save(newUser);
        assertThat(newUser).isNotNull();
        System.out.println(newUser);
    }

    @Test
    public void testAddUser2() {
        CHUser newUser = CHUser.builder()
                .fullname("Văn Lý Hải")
                .birthday(Date.valueOf("2002-02-15"))
                .email("lyhai1502@gmail.com")
                .password("password")
                .mobilePhone("0963441360")
                .address("Phú Yên")
                .build();

        userRepository.save(newUser);
        assertThat(newUser).isNotNull();
        System.out.println(newUser);
    }

    @Test
    @Transactional
    public void getUser() {
        Integer id = 2;
        CHUser chUser = userRepository.findById(id).orElse(null);

        System.out.println(chUser);
    }
}
