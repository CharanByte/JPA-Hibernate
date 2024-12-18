package com.xworkz.project.service;

import com.xworkz.project.dto.SignupDTO;
import org.springframework.stereotype.Service;

@Service
public interface SignupService {

    boolean valid(SignupDTO signupDTO);

}
