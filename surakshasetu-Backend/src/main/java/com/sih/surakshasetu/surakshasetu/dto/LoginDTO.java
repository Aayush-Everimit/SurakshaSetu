package com.sih.surakshasetu.surakshasetu.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO
{
    @NotNull
    private String username;
    @NotNull
    private String password;
}
