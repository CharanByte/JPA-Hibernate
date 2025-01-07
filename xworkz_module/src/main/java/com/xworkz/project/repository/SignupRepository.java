package com.xworkz.project.repository;

import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.entity.SignupEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SignupRepository {

    boolean save(SignupEntity signupEntity);

    String getUserName(String name);

    int checkUserName(SignupDTO signupDTO);

    long getCountOfName(String name);

    String[] validateUserName(String name);

    int updatePassword(String name, String newPassword);

    Long getCountOfUserName(String name);

    int getCountValue(String name, String password);

    SignupEntity getAll(String name, String password);

    int updateCountBy1(String name, int loginCount);

    int updateExistingDetails(SignupEntity signupDTO);

    List<String> getAllUserName();

    void updateLockTime(String name, LocalDateTime localDateTime);
}
