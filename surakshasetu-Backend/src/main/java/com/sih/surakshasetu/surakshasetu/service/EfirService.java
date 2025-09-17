package com.sih.surakshasetu.service;

import com.sih.surakshasetu.dto.EfirDTO;
import com.sih.surakshasetu.entity.EfirRecord;
import com.sih.surakshasetu.repository.EfirRecordRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EfirService {
    private final EfirRecordRepository efirRecordRepository;

    public EfirService(EfirRecordRepository efirRecordRepository) {
        this.efirRecordRepository = efirRecordRepository;
    }

    public List<EfirDTO> getAllEfirRecords() {
        return efirRecordRepository.findAllAsDTO();
    }

    public EfirDTO getEfirById(Long id) {
        EfirRecord  efirRecord = efirRecordRepository.findById(id).orElse(null);
        return convertToDTO(efirRecord);
    }
    private EfirDTO convertToDTO(EfirRecord efirRecord) {
        EfirDTO efirDTO = new EfirDTO();
        BeanUtils.copyProperties(efirRecord, efirDTO);
        return efirDTO;
    }
    private EfirRecord convertToEntity(EfirDTO efirDTO) {
        EfirRecord efirRecord = new EfirRecord();
        BeanUtils.copyProperties(efirDTO, efirRecord);
        return efirRecord;
    }

    public EfirDTO createEfir(EfirDTO efirDTO) {
        EfirRecord efirRecord = convertToEntity(efirDTO);
        efirRecord.setCreatedAt(java.time.LocalDateTime.now());
        efirRecordRepository.save(efirRecord);
        return convertToDTO(efirRecord);
    }

    public EfirDTO updateEfir(Long id, EfirDTO efirDTO)
    {
        EfirRecord efirRecord = efirRecordRepository.findById(id).orElse(null);
        assert efirRecord != null;
        efirRecord.setIncidentDetails(efirDTO.getIncidentDetails());
        efirRecord.setBlockchainVerifiedId(efirDTO.getBlockchainVerifiedId());
        efirRecord.setLastKnownLocation(efirDTO.getLastKnownLocation());
        efirRecord.setStatus(efirDTO.getStatus());
        efirRecordRepository.save(efirRecord);
        return convertToDTO(efirRecord);
    }
}
