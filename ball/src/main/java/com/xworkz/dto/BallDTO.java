package com.xworkz.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="ball_table")
@Setter
@Getter
public class BallDTO {
	@Id
	private int id;
	private String name;
	private int cost;

}
