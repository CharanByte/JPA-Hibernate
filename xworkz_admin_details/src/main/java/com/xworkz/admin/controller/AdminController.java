package com.xworkz.admin.controller;

import com.xworkz.admin.dto.AdminDTO;
import com.xworkz.admin.service.AdminSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    private AdminSrevice adminSrevice;
    @PostMapping("login")
    public String onSubmit(AdminDTO adminDTO){
        System.out.println(adminDTO);
        boolean isvalid=adminSrevice.valid(adminDTO);
        if(isvalid) {
            return "success.jsp";
        }
        return "Login.jsp";
    }
}
