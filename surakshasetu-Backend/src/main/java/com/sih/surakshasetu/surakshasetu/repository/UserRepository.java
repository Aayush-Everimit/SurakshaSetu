package com.sih.surakshasetu.repository;

import com.sih.surakshasetu.dto.UserDTO;
import com.sih.surakshasetu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long > {
    User findByUsername(String username);
    @Query("select new com.sih.surakshasetu.dto.UserDTO(q.userid, q.username, q.password, q.email, q.location, q.registeredAt, q.lastActiveAt) from User q")
    List<UserDTO> findAllDTO();

}
