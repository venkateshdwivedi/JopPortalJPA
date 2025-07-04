package com.example.jobportaljpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users") //since table name different from class name
public class User {

    @Id
    private int id;
	private String username;
	private String password;
}
