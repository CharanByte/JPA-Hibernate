package com.xworkz.project.restcontroller;

import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SigninUserNameController {

    @Autowired
    private SignupService signupService;

    @GetMapping(value = "/filedName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getName(@PathVariable String name) {
        System.out.println(name);

        Long count = signupService.getCountOfUserName(name);

        if (count > 0) {
            System.out.println("name  exists");
            return "";
        } else {
            System.out.println("UserName does't exist ");
            return "User Name does't exist ";
        }
}
}
