package com.xworkz.project.controller;

import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PasswordResetController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/passwordReset")
    public String onReset(String name, String oldPassword, String newPassword, String confirmPassword, Model model) {

        System.out.println(name + " " + oldPassword + " " + newPassword + " " + confirmPassword);
        boolean valid = signupService.validateUserName(name, oldPassword);
        if (valid) {
            int value = signupService.updatePassword(name, newPassword, confirmPassword);
            System.out.println("value : " + value);
            if (value > 0) {
                System.out.println("password updated");
                model.addAttribute("update", "Password successfully updated ");
                return "PasswordReset.jsp";
            } else {
                System.out.println("password no updated");
                model.addAttribute("noupdate", "Password not updated ");
                return "PasswordReset.jsp";
            }
        }
        model.addAttribute("updated", "password already updated");
        return "PasswordReset.jsp";
    }
}

