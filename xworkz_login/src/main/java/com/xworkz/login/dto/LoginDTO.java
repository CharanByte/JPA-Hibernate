package com.xworkz.login.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {


    private String name;
    private int age;
    private String email;
    private String password;
    private String conPassword;
    private  String phNo;
}
