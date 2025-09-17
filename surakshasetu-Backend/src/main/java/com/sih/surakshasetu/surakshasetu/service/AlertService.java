package com.sih.surakshasetu.surakshasetu.service;

import com.sih.surakshasetu.surakshasetu.dto.AlertDTO;
import com.sih.surakshasetu.surakshasetu.entity.Alert;
import com.sih.surakshasetu.surakshasetu.repository.AlertRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService
{
    private final AlertRepository alertRepository;
    public AlertService(AlertRepository alertRepository)
    {
        this.alertRepository = alertRepository;
    }
    
    private AlertDTO convertToDTO(Alert alert) {
        AlertDTO alertDTO = new AlertDTO();
        BeanUtils.copyProperties(alert, alertDTO);
        return alertDTO;
    }

    private Alert convertToEntity(AlertDTO alertDTO)
    {
        Alert alert = new Alert();
        BeanUtils.copyProperties(alertDTO, alert);
        return alert;
    }
    public List<AlertDTO> getAllAlerts()
    {
        return alertRepository.findAllAsDTO();
    }

    public AlertDTO getAlertById(Long id)
    {
        Alert alert = alertRepository.findById(id).orElse(null);
        if (alert == null) return null;
        return convertToDTO(alert);
    }

    public AlertDTO createAlert(AlertDTO alertDTO)
    {
        Alert alert = convertToEntity(alertDTO);
        alert.setTimestamp(java.time.LocalDateTime.now());
        alert.setViewed(false);
        Alert savedAlert = alertRepository.save(alert);
        return convertToDTO(savedAlert);
    }

    public AlertDTO updateAlert(Long id, AlertDTO alertDTO)
    {
        Alert alert = convertToEntity(alertDTO);
        alert.setTimestamp(alertDTO.getTimestamp());
        alert.setDescription(alertDTO.getDescription());
        alert.setAlertType(alertDTO.getAlertType());
        alert.setLocation(String.valueOf(alertDTO.getLocation()));
        alert.setViewed(alertDTO.getViewed());

        Alert updatedAlert = alertRepository.save(alert);
        return convertToDTO(updatedAlert);
    }
}
