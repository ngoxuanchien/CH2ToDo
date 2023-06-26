package com.example.chtodo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@Getter
@Setter
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private CHUser user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column
    private String description;

    @Column(nullable = false)
    private Date createdDate;

    @Column
    private Date expirationDate;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CHGroup group;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TaskList taskList;



}