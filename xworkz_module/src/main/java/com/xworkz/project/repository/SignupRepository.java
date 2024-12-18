package com.xworkz.project.repository;

import com.xworkz.project.entity.SignupEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository {

    boolean save(SignupEntity signupEntity);
}
