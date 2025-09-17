package com.sih.surakshasetu.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RiskPredictionDTO {

    private Long riskId;
    private Double latitude;
    private Double longitude;
    private Double riskScore;
    private String riskLevel;
    private LocalDateTime predictionTimestamp;

    public RiskPredictionDTO(Long riskId, Double latitude, Double longitude, Double riskScore, String riskLevel, LocalDateTime predictionTimestamp) {
        this.riskId = riskId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.predictionTimestamp = predictionTimestamp;
    }

    public RiskPredictionDTO() {}
}
