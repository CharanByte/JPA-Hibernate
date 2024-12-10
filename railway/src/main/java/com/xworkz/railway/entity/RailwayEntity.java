package com.xworkz.railway.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "scholarship_table")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@NamedQuery(name = "getPhonenumberById", query = "select pd.phone_no from RailwayEntity pd where pd.id= :setid")

@NamedQuery(name = "getNameByAge", query = "select pd.name from RailwayEntity pd where pd.age= :setAge")

@NamedQuery(name = "getDobByphno", query = "select pd.dob from RailwayEntity pd where pd.phone_no = :phno")

@NamedQuery(name = "getAddress&Name", query = "select pd.address from RailwayEntity pd where pd.id=:setid and pd.name=:setname")

public class RailwayEntity {

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

}
