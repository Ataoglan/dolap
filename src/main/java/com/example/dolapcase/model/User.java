package com.example.dolapcase.model;


import com.example.dolapcase.enums.Role;
import com.example.dolapcase.enums.UserStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "role") //ToDo cascade
    private Role role;
}
