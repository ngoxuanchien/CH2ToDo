package com.example.chtodo.repository;

import com.example.chtodo.model.CHGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<CHGroup, Integer> {
}
