package com.xworkz.login.service;

import com.xworkz.login.dto.LoginDTO;
import com.xworkz.login.dto.SigninDTO;
import com.xworkz.login.entity.LoginEntity;

import java.util.List;

public interface LoginService {

    boolean valid(LoginDTO loginDTO);

    boolean validPassword(SigninDTO signinDTO);

    List<LoginEntity> getAll(String name);
}
