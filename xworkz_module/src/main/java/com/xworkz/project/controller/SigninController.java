package com.xworkz.project.controller;

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

    SigninController() {
        System.out.println("SigninController");
    }

    @PostMapping("/signin")
    public String getSignin(String name, String password, Model model) {
        System.out.println(name + " " + password);


        boolean matches = signupService.validateSigninDetails(name, password);

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
