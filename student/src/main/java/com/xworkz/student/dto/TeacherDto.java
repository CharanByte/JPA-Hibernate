package com.xworkz.student.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "teacher_table")
public class TeacherDto {
	@Id
	private int id;
	@Column(name = "teacher_name")
	private String name;
	@Column(name = "teacher_age")
	private int age;
	@Column(name = "subject")
	private String sub;

}
