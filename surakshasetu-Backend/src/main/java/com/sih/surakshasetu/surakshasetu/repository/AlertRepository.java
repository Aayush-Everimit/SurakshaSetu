package com.sih.surakshasetu.surakshasetu.repository;

import com.sih.surakshasetu.surakshasetu.dto.AlertDTO;
import com.sih.surakshasetu.surakshasetu.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AlertRepository extends JpaRepository<Alert, Long>
{
    @Query("select new com.sih.surakshasetu.surakshasetu.dto.AlertDTO(q.alertId, q.alertType, q.description, q.timestamp, q.viewed, q.location) from Alert q")
    List<AlertDTO> findAllAsDTO();

}
