package com.sih.surakshasetu.surakshasetu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userid;

    @Column(unique = true, nullable=false, length = 50)
    private String username;

    @Column(nullable=false)
    @JsonIgnore
    private String password;

    @Column(unique = true, nullable=false, length = 100)
    private String email;

    @Column(length = 150)
    private String location;

    public enum Role {
        ADMIN,
        USER,
        VOLUNTEER
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length = 20)
    private Role role;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "last_active_at")
    private LocalDateTime lastActiveAt;
    //This is the User entity, later to be changed to admin.
}
