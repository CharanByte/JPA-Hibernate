package com.xworkz.project.repository;

import com.xworkz.project.dto.SigninDTO;
import com.xworkz.project.entity.SignupEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository {

    boolean save(SignupEntity signupEntity);

    String getUserName(String name);
}
