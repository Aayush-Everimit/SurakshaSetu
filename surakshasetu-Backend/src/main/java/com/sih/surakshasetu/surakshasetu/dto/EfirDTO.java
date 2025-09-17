package com.sih.surakshasetu.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EfirDTO {

    private Long efirId;
    private String touristUsername;
    private String blockchainVerifiedId;
    private String lastKnownLocation;
    private String incidentDetails;
    private LocalDateTime createdAt;
    private String status;

    public EfirDTO(Long efirId, String touristUsername, String blockchainVerifiedId, String lastKnownLocation, String incidentDetails, LocalDateTime createdAt, String status) {
        this.efirId = efirId;
        this.touristUsername = touristUsername;
        this.blockchainVerifiedId = blockchainVerifiedId;
        this.lastKnownLocation = lastKnownLocation;
        this.incidentDetails = incidentDetails;
        this.createdAt = createdAt;
        this.status = status;
    }

    public EfirDTO() {}
}
