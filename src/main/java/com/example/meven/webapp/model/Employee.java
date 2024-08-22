package com.example.meven.webapp.model;

import lombok.Data;

// Lombok : generate automatically getters and setters
@Data
public class Employee {
    private Integer id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;
}
