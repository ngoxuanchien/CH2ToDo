package com.example.chtodo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class CHGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CHUser owner;

    @ManyToMany(mappedBy = "groupList", fetch = FetchType.EAGER)
    @Builder.Default
    @JsonIgnore
    private List<CHUser> listUser = new ArrayList<>();
}
