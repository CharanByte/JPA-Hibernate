package com.xworkz.project.controller;

import com.xworkz.project.constants.LocationEnum;
import com.xworkz.project.entity.SignupEntity;
import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class SigninController {

    @Autowired
    private SignupService signupService;
    SignupEntity signupEntity;
    List<LocationEnum> locationEnums=new ArrayList<>(Arrays.asList(LocationEnum.values()));


    SigninController() {
        System.out.println("SigninController");
    }

    @GetMapping("/signin")
    public String signin(Model model){
        System.out.println("signupEntity :"+signupEntity);
        model.addAttribute("location",locationEnums);

        model.addAttribute("signupEntity",signupEntity);
        return "UpdateUserDetails.jsp";
    }
    @PostMapping("/signin")
    public String getSignin(String name, String password, Model model) {

        boolean matches = signupService.validateSigninDetails(name, password);
        if(matches){
             signupEntity=signupService.getAllDetails(name,password);
        }

        int value = signupService.getAll(name, password);
        if (value == 2) {
            model.addAttribute("failure", "incorrect password");
            return "Signin.jsp";

        } else if (value == 3) {
            model.addAttribute("locked", "your account is locked");
            return "Signin.jsp";
        }
        int count = signupService.getCountValue(name, password);
        if (matches && count >= 0) {

            model.addAttribute("success", "Successfully SignIn as " + name);
            return "Success.jsp";
        } else if (matches && count == -1) {
            return "PasswordReset.jsp";
        }
        model.addAttribute("failure", "incorrect password");
        model.addAttribute("dto", name);
        return "Signin.jsp";
    }


}
