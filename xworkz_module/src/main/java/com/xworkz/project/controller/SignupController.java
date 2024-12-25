package com.xworkz.project.controller;

import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class SignupController {

    @Autowired
    private SignupService signupService;

    SignupController() {
        System.out.println("running SignupController");
    }

    @PostMapping("/signup")
    public String signup(Model model, @Valid SignupDTO signupDTO, BindingResult bindingResult) {
        System.out.println(signupDTO);
        if(bindingResult.hasErrors()){
           model.addAttribute("error",bindingResult.getFieldError().getDefaultMessage());
            return "Signup.jsp";
        }
        boolean valid = signupService.valid(signupDTO);
        if (valid) {
             signupService.saveEmail(signupDTO.getEmail());
            model.addAttribute("success","successfully signedup as "+signupDTO.getName());
            return "Success.jsp";
        }
        return "Signup.jsp";
    }

}

