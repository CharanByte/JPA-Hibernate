package com.xworkz.login.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="login_tb")

@NamedQuery(name = "getPasswordName",query = "select a.password from LoginEntity a where a.name=:setName")
@NamedQuery(name = "getAll",query = "select a from LoginEntity a where a.name=:setName")

public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private  String phNo;
}
