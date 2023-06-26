package com.example.chtodoandroidapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Integer id;
    private String title;
    private String description;
    private Date createDate;
    private Date expirationDate;
}
