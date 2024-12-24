package com.xworkz.project.restcontroller;

import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class SignupUserNameController {

    @Autowired
    private SignupService signupService;

    @GetMapping(value = "/placeName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name) {
        System.out.println(name);
        long value = signupService.getCountOfName(name);
        if (value > 0) {
            System.out.println("name already exists");
            return "name already exists";
        } else {
            System.out.println("name does not exists");
            return "";
        }
    }
}
