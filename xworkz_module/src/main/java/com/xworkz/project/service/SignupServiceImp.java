package com.xworkz.project.service;

import com.xworkz.project.dto.PasswordResetDTO;
import com.xworkz.project.dto.SigninDTO;
import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.entity.SignupEntity;
import com.xworkz.project.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SignupServiceImp implements SignupService {

    @Autowired
    SignupRepository signupRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String passwordGenerate() {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String values = Capital_chars + Small_chars + numbers;

        Random rndm = new Random();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 6; i++) {

            password.append(values.charAt(rndm.nextInt(values.length())));

        }
        return password.toString();
    }


    @Override
    public boolean valid(SignupDTO signupDTO) {
        boolean valid = false;
        if (signupDTO.getEmail() != null) {
            SignupEntity signupEntity = new SignupEntity();
            String password = passwordGenerate();

            String encodedPassword=passwordEncoder.encode(password);
            System.out.println("password : "+password );
            System.out.println("encodedPassword : "+encodedPassword);
            signupEntity.setName(signupDTO.getName());
            signupEntity.setEmail(signupDTO.getEmail());
            signupEntity.setPassword(encodedPassword);
            signupEntity.setPhoneNo(signupDTO.getPhoneNo());
            signupEntity.setAltEmail(signupDTO.getAltEmail());
            signupEntity.setAltPhhoneNo(signupDTO.getAltPhhoneNo());
            signupEntity.setLocation(signupDTO.getLocation());
            signupEntity.setNo(-1);
            valid = true;

            System.out.println("generated password  : " + password);
            boolean saved = signupRepository.save(signupEntity);
        }
        return valid;
    }

    @Override
    public boolean getSigninDetails(SigninDTO signinDTO) {
        boolean passwordMaches = true;
        String password = signupRepository.getUserName(signinDTO.getName());
        if (signinDTO.getPassword() != null) {
            if (signinDTO.getPassword().equals(password))
                System.out.println("password matching");
            else {
                System.out.println("password not matching");
                passwordMaches = false;
            }
        }
        return passwordMaches;
    }

    @Override
    public int checkUserName(SignupDTO signupDTO) {
        int valid = signupRepository.checkUserName(signupDTO);
        return valid;
    }

    @Override
    public long getCountOfName(String name) {
        long value = signupRepository.getCountOfName(name);
        return value;
    }

    @Override
    public boolean validateUserName(PasswordResetDTO passwordResetDTO) {
        boolean isEqual=true;
      String[] getUserName=  signupRepository.validateUserName(passwordResetDTO);
        System.out.println("getUserName"+getUserName[0]);
        if(passwordResetDTO.getName().equals(getUserName[0]) && passwordResetDTO.getOldPassword().equals(getUserName[1]) && getUserName[2].equals("-1")) {
            System.out.println("equal");
        }
        else{
            System.out.println("User name is incorrect");
            isEqual=false;
        }

        return isEqual;
    }

    @Override
    public int updatePassword(PasswordResetDTO passwordResetDTO) {
        int value=0;
        if(passwordResetDTO.getNewPassword().equals(passwordResetDTO.getConfirmPassword())) {
            System.out.println("newPassword and comfirmPassword is equal");
            value = signupRepository.updatePassword(passwordResetDTO);
            System.out.println(value);
        }
        else {
            System.out.println("newPassword and comfirmPassword is notEqual");
        }
        return value;
    }
}
