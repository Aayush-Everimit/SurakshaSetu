package com.sih.surakshasetu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "alert")
public class Alert {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Long alertId;

    @Column(name = "alert_type", nullable = false, length = 100)
    private String alertType;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false, length = 150)
    private String location;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(nullable = false)
    private Boolean viewed = false;
}
