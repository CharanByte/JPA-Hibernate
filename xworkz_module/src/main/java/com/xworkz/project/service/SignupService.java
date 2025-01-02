package com.xworkz.project.service;

import com.xworkz.project.dto.SignupDTO;
import org.springframework.stereotype.Service;

@Service
public interface SignupService {

    boolean valid(SignupDTO signupDTO);

    boolean validateSigninDetails(String name,String password);

    int checkUserName(SignupDTO signupDTO);

    long getCountOfName(String name);

    boolean validateUserName(String name,String oldPassword);

    int updatePassword(String name,String newPassword,String confirmPassword);

    Long getCountOfUserName(String name);

    int getCountValue(String name, String password);

    int getAll(String name, String password);

    boolean saveEmail(String email);

    int updateExistingDetails(SignupDTO signupDTO);
}
