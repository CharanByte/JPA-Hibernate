package com.xworkz.project.dto;

import com.xworkz.project.entity.AbstractAdutEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class SignupDTO extends AbstractAdutEntity {

    @NotNull
    @Size(min = 2,max = 10 ,message = "Name must have greater 2 characters")
    private String name;
    @NotNull
    @Email(message = "Enter valid Email Id")
    private String email;
    @NotNull
    @Digits(integer = 10, fraction = 0 ,message = "Number should contain 10 digits")
    private String phoneNo;
    @Email(message = "Enter valid Email Id")
    private String altEmail;
    @Digits(integer = 10, fraction = 0 ,message = "Number should contain 10 digits")
    private String altPhoneNo;
    private String location;

}
