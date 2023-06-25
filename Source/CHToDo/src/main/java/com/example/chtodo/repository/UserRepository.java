package com.example.chtodo.repository;

import com.example.chtodo.model.CHUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CHUser, Integer> {
}
