package com.sih.surakshasetu.surakshasetu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tourist_identity")
public class TouristIdentity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "tourist_id")
    private Long touristId;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 150)
    private String location;

    @Column(nullable = false)
    private String password;
}
