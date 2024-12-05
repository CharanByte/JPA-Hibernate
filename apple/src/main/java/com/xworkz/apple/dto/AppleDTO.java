package com.xworkz.apple.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="college_table")
@NamedQuery(name="findAll", query="select a from AppleDTO a where a.id=3")
@NamedQuery(name="findNameByPhone", query="select b.name from AppleDTO b where b.phoneNo=7537635422")
@NamedQuery(name="findEmailById", query="select b.email from AppleDTO b where b.id=2")
@NamedQuery(name="findPhoneNoById", query="select b.phoneNo from AppleDTO b where b.id=2")
@NamedQuery(name="findAgeByName" ,query = "select b.age from AppleDTO b where b.id=3")
public class AppleDTO {
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
	private String phoneNo;

}
