package com.example.chtodo.repository;

import com.example.chtodo.model.database.CHUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CHUser, Integer> {
    Optional<CHUser> findByEmail(String email);
}
