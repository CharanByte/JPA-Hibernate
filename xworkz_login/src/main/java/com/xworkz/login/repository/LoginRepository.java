package com.xworkz.login.repository;

import com.xworkz.login.dto.LoginDTO;
import com.xworkz.login.dto.SigninDTO;
import com.xworkz.login.entity.LoginEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository {

    boolean save(LoginEntity loginEntity);

    String getPassword(SigninDTO signinDTO);

    List<LoginEntity> getAll(String name);
}
