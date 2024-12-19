package com.xworkz.project.service;

import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.entity.SignupEntity;
import com.xworkz.project.repository.SignupRepository;
import com.xworkz.project.repository.SignupRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SignupServiceImp implements SignupService {

    public String passwordGenerate() {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String values = Capital_chars + Small_chars + numbers;

        Random rndm = new Random();

       StringBuilder password=new StringBuilder();

        for (int i = 0; i < 6; i++) {

           password.append(values.charAt(rndm.nextInt(values.length())));

        }
        return password.toString();
    }


    @Override
    public boolean valid(SignupDTO signupDTO) {
        boolean valid=false;
        if(signupDTO.getEmail()!=null) {
             SignupEntity signupEntity=new SignupEntity();
            System.out.println("length : "+signupDTO.getEmail().length());
            String password = passwordGenerate();
            signupEntity.setName(signupDTO.getName());
            signupEntity.setEmail(signupDTO.getEmail());
            signupEntity.setPassword(password);
            signupEntity.setPhoneNo(signupDTO.getPhoneNo());
            signupEntity.setAltEmail(signupDTO.getAltEmail());
            signupEntity.setAltPhhoneNo(signupDTO.getAltPhhoneNo());
            signupEntity.setLocation(signupDTO.getLocation());

            valid=true;

            System.out.println( "generated password  : "+password);
            SignupRepository signupRepository=new SignupRepositoryImp();
            boolean saved=signupRepository.save(signupEntity);
        }
        return valid;
    }
}
