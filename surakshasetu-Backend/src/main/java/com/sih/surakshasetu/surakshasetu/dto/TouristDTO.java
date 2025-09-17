package com.sih.surakshasetu.surakshasetu.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TouristDTO {

    private Long touristId;
    private String username;

    @Email
    private String email;

    private String location;

    public TouristDTO(Long touristId, String username, String email, String location) {
        this.touristId = touristId;
        this.username = username;
        this.email = email;
        this.location = location;
    }

    public TouristDTO() {
        // no-arg constructor for frameworks
    }
}
