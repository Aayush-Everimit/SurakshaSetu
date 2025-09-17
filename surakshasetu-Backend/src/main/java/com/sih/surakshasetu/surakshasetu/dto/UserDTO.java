package com.sih.surakshasetu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {

    private long userid;

    @NotBlank
    private String username;

    private String password;

    private String email;

    private String location;

    private LocalDateTime registeredAt;

    private LocalDateTime lastActiveAt;

    public UserDTO(long userid, String username, String password, String email, String location, LocalDateTime registeredAt, LocalDateTime lastActiveAt) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
        this.registeredAt = registeredAt;
        this.lastActiveAt = lastActiveAt;
    }

    public UserDTO() {}
}
