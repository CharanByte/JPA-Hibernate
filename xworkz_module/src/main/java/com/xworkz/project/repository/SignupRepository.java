package com.xworkz.project.repository;

import com.xworkz.project.dto.PasswordResetDTO;
import com.xworkz.project.dto.SigninDTO;
import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.entity.SignupEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository {

    boolean save(SignupEntity signupEntity);

    String getUserName(String name);

    int checkUserName(SignupDTO signupDTO);

    long getCountOfName(String name);

    String[] validateUserName(PasswordResetDTO passwordResetDTO);

    int updatePassword(PasswordResetDTO passwordResetDTO);
}
