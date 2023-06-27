package com.example.chtodo.repository;

import com.example.chtodo.model.database.CHGroup;
import com.example.chtodo.model.database.CHUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<CHGroup, Integer> {
    List<CHGroup> findByOwner(CHUser owner);
}
