package com.xworkz.admin.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "login_table")
@RequiredArgsConstructor
@Data
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String conPassword;
    private  String phNo;


}
