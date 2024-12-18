package com.xworkz.project.controller;

import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SignupController {

    @Autowired
    private SignupService signupService;
    SignupController(){
        System.out.println("running SignupController");
    }

    @PostMapping("/signup")
    public String signup(SignupDTO signupDTO){
        System.out.println(signupDTO);
        boolean valid=signupService.valid(signupDTO);
        if(valid){
            return "Success.jsp";
        }
        return "Signup.jsp";
    }
}
