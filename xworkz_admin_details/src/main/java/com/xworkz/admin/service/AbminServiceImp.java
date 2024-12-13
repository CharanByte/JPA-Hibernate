package com.xworkz.admin.service;

import com.xworkz.admin.dto.AdminDTO;

import com.xworkz.admin.entity.AdminEntity;
import com.xworkz.admin.repository.AdminRepository;
import com.xworkz.admin.repository.AdminRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbminServiceImp  implements AdminSrevice{


    @Override
    public boolean valid(AdminDTO adminDTO) {
        boolean isvalid=true;

        String name=adminDTO.getName();
        if(name.length()>5 && !name.matches("^[a-zA-Z0-9]+$")){
            System.out.println("name valid");
            isvalid=true;
        }
        else {
            isvalid=false;
            System.out.println("name is invalid");
        }
        int age=adminDTO.getAge();
        if(age>18){
            isvalid=true;
            System.out.println("age is valid");
        }
        else{
            isvalid=false;
            System.out.println("age is invalid");
            return isvalid;
        }
        String email=adminDTO.getEmail();
        if(email.contains("@")){
            isvalid=true;
            System.out.println("email is valid");
        }
        else{
            isvalid=false;
            System.out.println("email is invalid");
            return isvalid;
        }

        String password=adminDTO.getPassword();


        String conpassword=adminDTO.getConPassword();
        if(conpassword.equals(password)){
            isvalid=true;
            System.out.println("comfpassword is valid");
        }
        else{
            isvalid=false;
            System.out.println("confpassword is in valid");
            return  isvalid;
        }

        String phNo=adminDTO.getPhNo();
        if(phNo.startsWith("9") && phNo.length()==10){
            isvalid=true;
            System.out.println("phno is valid");
        }
        else {
            isvalid=false;
            System.out.println("phone is in valid");
            return  isvalid;
        }

if(isvalid) {
    AdminEntity entity = new AdminEntity();
    entity.setName(adminDTO.getName());
    entity.setAge(adminDTO.getAge());
    entity.setEmail(adminDTO.getEmail());
    entity.setPassword(adminDTO.getPassword());
    entity.setConPassword(adminDTO.getConPassword());
    entity.setPhNo(adminDTO.getPhNo());
    AdminRepository adminRepository=new AdminRepositoryImp();
    boolean saved = adminRepository.save(entity);
}
        System.out.println(isvalid);
        return isvalid;
    }
}
