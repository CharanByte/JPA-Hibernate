package com.xworkz.project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PasswordResetDTO {

    private String name;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

}
