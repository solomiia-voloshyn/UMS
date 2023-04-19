package com.example.usermanagementsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestLoginDto {
    @NotBlank(message = "login must be not blank")
    private String login;
    @NotBlank(message = "login must be not blank")
    private String password;
}
