package com.xworkz.project.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "signUp_table")
@NamedQuery(name = "getPasswordByName", query = "select a.password from SignupEntity a where a.name=:setName")
@NamedQuery(name = "getCountByName", query = "select count(a.name) from SignupEntity a where a.name=:setName")
@NamedQuery(name = "getNameByUserName", query = "select a.name from SignupEntity a where a.name=:setName")
@NamedQuery(name = "getOldPasswordByName", query = "select a.password from SignupEntity a where a.name=:setName")
@NamedQuery(name = "getCountBYName", query = "select a.no from SignupEntity a where a.name=:setName")
@NamedQuery(name = "updatePassword&CountByName", query = "UPDATE SignupEntity a SET a.password = :setPassword ,a.no=:setNo WHERE a.name = :setName")
@NamedQuery(name = "getCountValue", query = "select a.no from SignupEntity a WHERE a.name = :setName and a.password=:setPassword")
@NamedQuery(name = "updateCountValue", query = "UPDATE SignupEntity a SET a.no=:setNo WHERE a.name = :setName")
@NamedQuery(name = "getAll", query = "select a from SignupEntity a where a.name=:getName")
@NamedQuery(name = "updateExistingDetailsByName", query = "UPDATE SignupEntity a SET a.email=:setEmail,a.phoneNo=:setPhoneNo,a.altEmail=:setAltEmail,a.altPhhoneNo=:setaltPhoneNo,a.location=:setLocation,a.updatedBy=:setupdatedBy,a.updatedDate=:setupdatedDate WHERE a.name=:setName")

public class SignupEntity extends AbstractAdutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_phoneNo")
    private String phoneNo;
    @Column(name = "user_altEmail")
    private String altEmail;
    @Column(name = "user_altPhhoneNo")
    private String altPhhoneNo;
    @Column(name = "user_location")
    private String location;
    @Column(name = "count_value")
    private int no;
}
