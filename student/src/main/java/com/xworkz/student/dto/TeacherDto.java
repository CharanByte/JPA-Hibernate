package com.xworkz.student.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name="teacher_table")
public class TeacherDto {
	@Id
	private int id;
	private String name;
	private int age;
	private String subject;

}
