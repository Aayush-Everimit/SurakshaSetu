package com.sih.surakshasetu.surakshasetu.service;

import com.sih.surakshasetu.surakshasetu.dto.AlertDTO;
import com.sih.surakshasetu.surakshasetu.dto.RiskPredictionDTO;
import com.sih.surakshasetu.surakshasetu.dto.UserDTO;
import com.sih.surakshasetu.surakshasetu.entity.Alert;
import com.sih.surakshasetu.surakshasetu.entity.RiskPrediction;
import com.sih.surakshasetu.surakshasetu.repository.RiskPredictionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiskPredictionService {
    private final RiskPredictionRepository riskPredictionRepository;

    public RiskPredictionService(RiskPredictionRepository riskPredictionRepository) {
        this.riskPredictionRepository = riskPredictionRepository;
    }

    public List<RiskPredictionDTO> getAllRiskPredictions() {
        return riskPredictionRepository.getAllRiskPredictions();
    }

    public RiskPredictionDTO getRiskPredictionById(Long id)
    {
        RiskPrediction riskPrediction = riskPredictionRepository.findById(id).orElse(null);
        if (riskPrediction == null) return null;
        return convertToDTO(riskPrediction);
    }
    private RiskPredictionDTO convertToDTO(RiskPrediction riskPrediction) {
        RiskPredictionDTO riskPredictionDTO = new RiskPredictionDTO();
        BeanUtils.copyProperties(riskPrediction, riskPredictionDTO);
        return riskPredictionDTO;
    }

    public RiskPredictionDTO createRiskPrediction(RiskPredictionDTO dto) {
        RiskPrediction riskPrediction = convertToEntity(dto);
        RiskPrediction saved = riskPredictionRepository.save(riskPrediction);
        return convertToDTO(saved);
    }

    private RiskPrediction convertToEntity(RiskPredictionDTO dto)
    {
        RiskPrediction riskPrediction = new RiskPrediction();
        BeanUtils.copyProperties(dto, riskPrediction);
        return riskPrediction;
    }

    public RiskPredictionDTO updateRiskPrediction(Long id, RiskPredictionDTO dto) {
        return riskPredictionRepository.findById(id).map(existing -> {
            existing.setLatitude(dto.getLatitude());
            existing.setLongitude(dto.getLongitude());
            existing.setRiskScore(dto.getRiskScore());
            existing.setRiskLevel(dto.getRiskLevel());
            existing.setPredictionTimestamp(dto.getPredictionTimestamp());
            RiskPrediction updated = riskPredictionRepository.save(existing);
            return convertToDTO(updated);
        }).orElse(null);
    }
}
