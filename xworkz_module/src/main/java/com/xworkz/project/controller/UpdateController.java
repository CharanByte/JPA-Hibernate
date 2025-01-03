package com.xworkz.project.controller;

import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UpdateController {
    @Autowired
    SignupService signupService;




    @PostMapping("/update")
    public String update(SignupDTO signupDTO, Model model) {
        System.out.println("onupdate : " + signupDTO);
        int updatedValue = signupService.updateExistingDetails(signupDTO);
        if (updatedValue == 1) {
            System.out.println(updatedValue);

            model.addAttribute("updateSuccess", signupDTO.getName() + " Your Registration details Updated Successfully");
            return "UpdateUserDetails.jsp";
        }
        return "UpdateUserDetails.jsp";
    }
}
