package com.example.chtodo.model.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@Getter
@Setter
@Builder
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private CHUser user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column
    private String description;

    @Column(nullable = false)
    private long createdDate;

    @Column
    private long expirationDate;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private CHGroup group;

    @ManyToOne
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;
    @Override
    public String toString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
