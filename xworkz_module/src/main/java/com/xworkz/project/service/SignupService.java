package com.xworkz.project.service;

import com.xworkz.project.dto.PasswordResetDTO;
import com.xworkz.project.dto.SigninDTO;
import com.xworkz.project.dto.SignupDTO;
import org.springframework.stereotype.Service;

@Service
public interface SignupService {

    boolean valid(SignupDTO signupDTO);

    boolean getSigninDetails(SigninDTO signinDTO);

    int checkUserName(SignupDTO signupDTO);

    long getCountOfName(String name);

    boolean validateUserName(PasswordResetDTO passwordResetDTO);

    int updatePassword(PasswordResetDTO passwordResetDTO);
}
