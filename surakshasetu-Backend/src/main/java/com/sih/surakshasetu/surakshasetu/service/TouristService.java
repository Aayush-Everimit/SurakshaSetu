package com.sih.surakshasetu.service;

import com.sih.surakshasetu.dto.TouristDTO;
import com.sih.surakshasetu.entity.RiskPrediction;
import com.sih.surakshasetu.entity.TouristIdentity;
import com.sih.surakshasetu.repository.TouristIdentityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService
{
    private final TouristIdentityRepository touristRepo;
    public TouristService(TouristIdentityRepository touristRepo) {
        this.touristRepo = touristRepo;
    }

    public List<TouristDTO> getAllTourists() {
        return touristRepo.findAllTourists();
    }

    public Optional<TouristDTO> getTouristById(Long id) {
        TouristIdentity touristIdentity = touristRepo.findById(id).orElse(null);
        if (touristIdentity == null) return null;
        return Optional.of(convertToDTO(touristIdentity));
    }

    public TouristDTO registerTourist(TouristDTO dto) {
        TouristIdentity entity = convertToEntity(dto);
        TouristIdentity saved = touristRepo.save(entity);
        return convertToDTO(saved);
    }

    private TouristDTO convertToDTO(TouristIdentity entity) {
        TouristDTO dto = new TouristDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private TouristIdentity convertToEntity(TouristDTO dto) {
        TouristIdentity entity = new TouristIdentity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
