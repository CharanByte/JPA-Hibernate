package com.xworkz.login.service;

import com.xworkz.login.dto.LoginDTO;
import com.xworkz.login.dto.SigninDTO;
import com.xworkz.login.entity.LoginEntity;
import com.xworkz.login.repository.LoginRepository;
import com.xworkz.login.repository.LoginRepositoryImp;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean valid(LoginDTO loginDTO) {


        boolean isvalid = true;

        String name = loginDTO.getName();
        if (name.length() > 5 && !name.matches("^[a-zA-Z0-9]+$")) {
            System.out.println("name valid");

        } else {
            isvalid = false;
            System.out.println("name is invalid");
        }
        int age = loginDTO.getAge();
        if (age > 18) {

            System.out.println("age is valid");
        } else {
            isvalid = false;
            System.out.println("age is invalid");

        }
        String email = loginDTO.getEmail();
        if (email.contains("@")) {

            System.out.println("email is valid");
        } else {
            isvalid = false;
            System.out.println("email is invalid");

        }

        String password = loginDTO.getPassword();


        String conpassword = loginDTO.getConPassword();
        if (conpassword.equals(password)) {

            System.out.println("comfpassword is valid");
        } else {
            isvalid = false;
            System.out.println("confpassword is in valid");

        }

        String phNo = loginDTO.getPhNo();
        if (phNo.startsWith("9") && phNo.length() == 10) {

            System.out.println("phno is valid");
        } else {
            isvalid = false;
            System.out.println("phone is in valid");

        }

        if (isvalid) {

            String rawPassword = loginDTO.getPassword();
            //  String enncryPassword=bCryptPasswordEncoder.encode(loginDTO.getPassword());
            String encryptedpassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
            LoginEntity entity = new LoginEntity();
            entity.setName(loginDTO.getName());
            entity.setAge(loginDTO.getAge());
            entity.setEmail(loginDTO.getEmail());
            entity.setPassword(encryptedpassword);


            System.out.println(encryptedpassword);
            entity.setPhNo(loginDTO.getPhNo());
            LoginRepository adminRepository = new LoginRepositoryImp();
            boolean saved = adminRepository.save(entity);
        }
        System.out.println(isvalid);
        return isvalid;
    }

    @Override
    public boolean validPassword(SigninDTO signinDTO) {
        boolean istrue = false;
        LoginRepository loginRepository1 = new LoginRepositoryImp();
        String password = loginRepository1.getPassword(signinDTO);
        System.out.println(password);
        boolean isPasswordMatch = BCrypt.checkpw(signinDTO.getPassword(), password);
        if (password != null) {

            if (isPasswordMatch) {
                System.out.println("password matching");
                istrue = true;
                return istrue;

            } else {
                System.out.println("password not  matching");
                return istrue;
            }

        }
        return istrue;
    }

    @Override
    public List<LoginEntity> getAll(String name) {
        LoginRepository loginRepository1 = new LoginRepositoryImp();
        List<LoginEntity> list = loginRepository1.getAll(name);
        return list;
    }


}
