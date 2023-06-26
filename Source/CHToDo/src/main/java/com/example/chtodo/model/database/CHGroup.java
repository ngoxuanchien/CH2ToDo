package com.example.chtodo.model.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private CHUser owner;

    @ManyToMany(mappedBy = "groupList", fetch = FetchType.EAGER)
    @Builder.Default
    private List<CHUser> listUser = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private List<Task> listTask = new ArrayList<>();

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
