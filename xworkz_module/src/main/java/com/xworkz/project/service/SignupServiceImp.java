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

    public char[] passwordGenerate() {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String values = Capital_chars + Small_chars +
                numbers;


        Random rndm = new Random();

        char[] password = new char[6];

        for (int i = 0; i < 6; i++) {

            password[i] = values.charAt(rndm.nextInt(values.length()));

        }
        return password;
    }

    @Override
    public boolean valid(SignupDTO signupDTO) {
        boolean valid=false;
        if(signupDTO.getEmail()!=null) {
             SignupEntity signupEntity=new SignupEntity();
            System.out.println("length : "+signupDTO.getEmail().length());
            char[] password = passwordGenerate();
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
