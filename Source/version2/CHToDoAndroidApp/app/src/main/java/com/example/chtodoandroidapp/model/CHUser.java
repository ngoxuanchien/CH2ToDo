package com.example.chtodoandroidapp.model;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CHUser {
    private String fullname;
    private Date birthday;
    private String email;
    private String address;
    private String mobilePhone;
}
