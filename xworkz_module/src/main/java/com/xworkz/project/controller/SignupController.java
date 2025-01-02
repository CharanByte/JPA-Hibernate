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
   // @GetMapping
//    public String SignUp(SignupDTO signupDTO,Model model){
//        System.out.println("holle");
//        List<LocationEnum> locationEnums=new ArrayList<>(Arrays.asList(LocationEnum.values()));
//        locationEnums.forEach(a-> System.out.println(a));
//        model.addAttribute("locationEnums",locationEnums);
//        return "Signup.jsp";
//    }

//    @PostMapping ("/signup")
//    public String SignUp(SignupDTO signupDTO,Model model){
//        System.out.println("update : "+signupDTO);
//        model.addAttribute("name",signupDTO.getName());
//        System.out.println(signupDTO.getName());
//        return "UpdateUserDetails.jsp";
 //   }

    @PostMapping("/signup")
    public String signup(Model model, @Valid SignupDTO signupDTO, BindingResult bindingResult) {

        System.out.println(signupDTO);
        if(bindingResult.hasErrors()){
            System.out.println("valididation : "+bindingResult.getAllErrors());
           model.addAttribute("error",bindingResult.getAllErrors());
            System.out.println();
            return "Signup.jsp";
        }
        boolean valid = signupService.valid(signupDTO);
        if (valid) {
             signupService.saveEmail(signupDTO.getEmail());
             model.addAttribute("success","successfully signedup as "+signupDTO.getName());

             model.addAttribute("dto",signupDTO);

            return "Success.jsp";
        }
        return "Signup.jsp";
    }

}
