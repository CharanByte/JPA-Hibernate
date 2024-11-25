package com.xworkz.student.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="student_table")
public class StudentDto {
	@Id
	private int id;
	private String name;
	private int age;
}
