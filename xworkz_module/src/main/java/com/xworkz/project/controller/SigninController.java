package com.xworkz.project.controller;

import com.xworkz.project.dto.SigninDTO;
import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SigninController {

    @Autowired
    private SignupService signupService;

    SigninController(){
        System.out.println("SigninController");
    }
    @PostMapping("/signin")
    public String signin(SigninDTO signinDTO, Model model){
        System.out.println(signinDTO);
        boolean matches=signupService.getSigninDetails(signinDTO);
        if(matches){
            model.addAttribute("success" ,"Successfully SignIn as "+signinDTO.getName());
            return "Success.jsp";
        }
        model.addAttribute("failure","incorrect password");
        model.addAttribute("dto",signinDTO);
        return "Signin.jsp";
    }
}
