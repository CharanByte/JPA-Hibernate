package com.xworkz.login.controller;

import com.xworkz.login.dto.LoginDTO;
import com.xworkz.login.dto.SigninDTO;
import com.xworkz.login.entity.LoginEntity;
import com.xworkz.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    LoginController() {
        System.out.println("running LoginController");
    }

    @PostMapping("/signup")
    public String signUp(LoginDTO loginDTO) {
        System.out.println(loginDTO);
        boolean validte = loginService.valid(loginDTO);
        if (validte)
            return "Signin.jsp";
        else
            return "Signup.jsp";
    }

    @PostMapping("/signin")
    public String signin(SigninDTO signinDTO, Model model) {
        System.out.println(signinDTO);
        boolean present = loginService.validPassword(signinDTO);
        if (present) {
            model.addAttribute("username", signinDTO.getName());
            return "Success.jsp";
        } else
            return "Signin.jsp";
    }

    @GetMapping("/getdetails")
    public String getDetails(String name, Model model) {
        System.out.println(name);
        List<LoginEntity> loginEntities = loginService.getAll(name);
        System.out.println(loginEntities);
        model.addAttribute("printAll", loginEntities);
        return "Success.jsp";

    }

}
