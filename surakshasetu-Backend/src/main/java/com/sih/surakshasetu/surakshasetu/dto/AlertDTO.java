package com.sih.surakshasetu.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.stream.Location;
import java.time.LocalDateTime;

@Getter
@Setter
public class AlertDTO {
    private Long alertId;
    private String alertType;
    private String description;
    private LocalDateTime timestamp;
    private Boolean viewed;
    private String location;

    public AlertDTO() {}

    public AlertDTO(Long alertId, String alertType, String description, LocalDateTime timestamp, Boolean viewed, String location) {
        this.alertId = alertId;
        this.alertType = alertType;
        this.description = description;
        this.timestamp = timestamp;
        this.viewed = viewed;
        this.location = location;
    }
}
