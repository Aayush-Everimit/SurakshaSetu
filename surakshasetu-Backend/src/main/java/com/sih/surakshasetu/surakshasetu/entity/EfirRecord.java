package com.sih.surakshasetu.surakshasetu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "efir_record")
public class EfirRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "efir_id")
    private Long efirId;

    @Column(name = "tourist_username", nullable = false, length = 50)
    private String touristUsername;

    @Column(name = "blockchain_verified_id") //length param define
    private String blockchainVerifiedId;  // SBT

    @Column(name = "last_known_location", length = 150)
    private String lastKnownLocation;

    @Column(name = "incident_details", length = 1000)
    private String incidentDetails;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(length = 50)
    private String status;
}
