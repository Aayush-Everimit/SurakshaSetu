package com.sih.surakshasetu.repository;

import com.sih.surakshasetu.dto.RiskPredictionDTO;
import com.sih.surakshasetu.entity.RiskPrediction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RiskPredictionRepository extends CrudRepository<RiskPrediction, Long> {
    @Query("select new com.sih.surakshasetu.dto.RiskPredictionDTO(q.riskId, q.latitude, q.longitude, q.riskScore, q.riskLevel, q.predictionTimestamp) from RiskPrediction q")
    List<RiskPredictionDTO> getAllRiskPredictions();

}
