package com.xworkz.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="stu")

@NamedQuery(name="findAll" ,query = "select a from CourseEntity a")
@NamedQuery(name="findAllById",query="select a from CourseEntity a where a.id=:setId")
@NamedQuery(name="findNameById",query = "select a.name from CourseEntity a where a.id=:setid")
@NamedQuery(name="findAgeByname",query = "select a.age from CourseEntity a where a.name=:findNameById")
@NamedQuery(name="findHeightByweight", query = "select a.height from CourseEntity a where a.weight=:setWeight")
public class CourseEntity {
	@Id
	private	int id;
	@Column(name="st_name")
	private String name;
	@Column(name="St_age")
	private int age;
	@Column(name="St_height")
	private float height;
	@Column(name="St_weight")
	private double weight;
	@Column(name="_st_branch")
	private String branch;
	@Column(name="isPassed")
	private boolean isPassed;
}
