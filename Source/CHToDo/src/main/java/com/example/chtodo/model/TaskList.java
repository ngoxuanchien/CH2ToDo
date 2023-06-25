package com.example.chtodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CHUser user;

    @OneToMany
    @JoinTable(name = "Task")
    @JsonIgnore
    private List<Task> listTask = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CHGroup group;
}
