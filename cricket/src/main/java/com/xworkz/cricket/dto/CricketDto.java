package com.xworkz.cricket.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="cricket_table")
@Setter
@Getter
public class CricketDto {
	@Id
	private int id;
	private String name;
	private int playersNo;

}
