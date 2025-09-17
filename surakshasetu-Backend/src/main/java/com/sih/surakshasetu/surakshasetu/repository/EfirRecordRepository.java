package com.sih.surakshasetu.surakshasetu.repository;

import com.sih.surakshasetu.surakshasetu.dto.EfirDTO;
import com.sih.surakshasetu.surakshasetu.entity.EfirRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EfirRecordRepository extends JpaRepository<EfirRecord, Long>
{
    @Query("select new com.sih.surakshasetu.surakshasetu.dto.EfirDTO(q.efirId, q.touristUsername, q.blockchainVerifiedId, q.lastKnownLocation, q.incidentDetails, q.createdAt, q.status) from EfirRecord q")
    List<EfirDTO> findAllAsDTO();

}
