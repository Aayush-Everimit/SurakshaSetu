package com.sih.surakshasetu.surakshasetu.repository;

import com.sih.surakshasetu.surakshasetu.dto.TouristDTO;
import com.sih.surakshasetu.surakshasetu.entity.TouristIdentity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TouristIdentityRepository extends JpaRepository<TouristIdentity, Long>
{

    Optional<TouristIdentity> findByUsername(@NotBlank(message = "Username is required") String username);
    Optional<TouristIdentity> findByEmail(@Email(message = "Invalid email format") @NotBlank(message = "Email is required") String email);

    @Query("select new com.sih.surakshasetu.surakshasetu.dto.TouristDTO(q.touristId, q.username, q.email, q.location) from TouristIdentity q")
    List<TouristDTO> findAllTourists();

}
