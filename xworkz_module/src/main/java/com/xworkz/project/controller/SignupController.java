package com.xworkz.project.controller;


import com.xworkz.project.constants.LocationEnum;
import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/")
public class SignupController {

    @Autowired
    private SignupService signupService;
    List<LocationEnum> locationEnums = new ArrayList<>(Arrays.asList(LocationEnum.values()));

    SignupController() {
        System.out.println("running SignupController");
    }

    @GetMapping("/Signup")
    public String SignUp(Model model) {

        model.addAttribute("location", locationEnums);

        return "Signup.jsp";
    }

    @PostMapping("/signup")
    public String signup(Model model, @Valid SignupDTO signupDTO, BindingResult bindingResult) {

        System.out.println(signupDTO);
        model.addAttribute("location", locationEnums);
        if (bindingResult.hasErrors()) {
            System.out.println("valididation : " + bindingResult.getAllErrors());
            model.addAttribute("error", bindingResult.getAllErrors());
            System.out.println();
            return "Signup.jsp";
        }
        boolean valid = signupService.valid(signupDTO);
        if (valid) {
            signupService.saveEmail(signupDTO.getEmail());
            model.addAttribute("success", "Registered Successfully as " + signupDTO.getName());

            model.addAttribute("dto", signupDTO);

            return "Success.jsp";
        }
        return "Signup.jsp";
    }


}
