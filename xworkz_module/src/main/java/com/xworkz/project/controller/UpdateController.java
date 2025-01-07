
package com.xworkz.project.controller;

import com.xworkz.project.constants.LocationEnum;
import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class UpdateController {
    @Autowired
    SignupService signupService;
    List<LocationEnum> locationEnums = new ArrayList<>(Arrays.asList(LocationEnum.values()));
    String filePath;

    @PostMapping("/update")
    public String update(@RequestParam("thisfile") MultipartFile multipartFile ,SignupDTO signupDTO, Model model) throws IOException{


        if (multipartFile.isEmpty()) {
            return "UpdateUserDetails.jsp";
        } else {
            System.out.println(multipartFile);
            System.out.println(multipartFile.getOriginalFilename());
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get("C:\\img\\" + System.currentTimeMillis() + ".jpg");
            Files.write(path, bytes);
            filePath = path.getFileName().toString();
        }
        model.addAttribute("location", locationEnums);
        int updatedValue = signupService.updateExistingDetails(signupDTO,filePath);
        if (updatedValue == 1) {
            System.out.println(updatedValue);

            model.addAttribute("updateSuccess", signupDTO.getName() + " Your Registration details Updated Successfully");
            return "UpdateUserDetails.jsp";
        }
        return "UpdateUserDetails.jsp";
    }



}
