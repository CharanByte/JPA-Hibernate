package com.xworkz.project.service;

import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.entity.SignupEntity;
import com.xworkz.project.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SignupServiceImp implements SignupService {

    @Autowired
    private SignupRepository signupRepository;

    public char[] passwordGenerate(int length) {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = Capital_chars + Small_chars +
                numbers + symbols;


        Random rndm = new Random();

        char[] password = new char[length];

        for (int i = 0; i < length; i++) {

            password[i] = values.charAt(rndm.nextInt(values.length()));

        }
        return password;
    }

    @Override
    public boolean valid(SignupDTO signupDTO) {

        if(signupDTO.getEmail()!=null) {
             SignupEntity signupEntity=new SignupEntity();
            char[] password = passwordGenerate(signupDTO.getEmail().length());
            signupEntity.setName(signupDTO.getName());
            signupEntity.setEmail(signupDTO.getEmail());
            signupEntity.setPassword(password);
            signupEntity.setPhoneNo(signupDTO.getPhoneNo());
            signupEntity.setAltEmail(signupDTO.getAltEmail());
            signupEntity.setAltPhhoneNo(signupDTO.getAltPhhoneNo());
            signupEntity.setLocation(signupDTO.getLocation());

            System.out.println(password);
            boolean saved=signupRepository.save(signupEntity);
        }
        return signupDTO.getEmail()!=null?true:false;
    }
}
