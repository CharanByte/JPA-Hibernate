package com.xworkz.project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupDTO {

    private String name;
    private String email;
    private String phoneNo;
    private String altEmail;
    private String altPhhoneNo;
    private String location;
}
