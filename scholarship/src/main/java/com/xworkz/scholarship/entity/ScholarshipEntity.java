package com.xworkz.scholarship.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "scholarship_table")
@Getter
@ToString
@NoArgsConstructor

@NamedQuery(name = "updateName", query = "update ScholarshipEntity up set up.name= :setname where up.email= :setEmail and up.phone_no= :setNo")
@NamedQuery(name="updateAge",query = "update ScholarshipEntity up set up.age=:setAge where up.phone_no= :setNo and up.isEligible=:setisEligible")
@NamedQuery(name="getAll",query = "select a from ScholarshipEntity a")
@NamedQuery(name = "getNameAndEmailById" ,query = "select s.name,s.email from ScholarshipEntity s where s.id=:setId")
@NamedQuery(name="getCountByAge" ,query = "select count(a) from ScholarshipEntity a where a.age>=:setAge")
@NamedQuery(name = "getNameEmailPhoneNoById" ,query = "select a.name,a.email,a.phone_no from ScholarshipEntity a where a.id=:setId ")
@NamedQuery(name = "getAllByEmailAndNumber" ,query = "select a from ScholarshipEntity a where a.email=:setemail and a.phone_no=:setNo")
@NamedQuery(name="deleteByNameAndAge" ,query = "delete from ScholarshipEntity a where a.name=:setname and a.age=:setAge")

public class ScholarshipEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "student_name")
	private String name;
	@Column(name = "student_age")
	private int age;
	@Column(name = "student_email")
	private String email;
	@Column(name = "student_phoneNo")
	private long phone_no;
	@Column(name = "student_dob")
	private Date dob;
	@Column(name = "student_income")
	private Double income;
	@Column(name = "address")
	private String address;
	@Column(name = "current_year")
	private int year;
	@Column(name = "isEligible")
	private boolean isEligible;

	public ScholarshipEntity(String name, int age, String email, long phone_no, Date date, Double income,
			String address, int year, boolean isEligible) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone_no = phone_no;
		this.dob = date;
		this.income = income;
		this.address = address;
		this.year = year;
		this.isEligible = isEligible;
	}

}
