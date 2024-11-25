package com.xworkz.mobile.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="mobile_table")
public class MobileDto {
	@Id
	private int id;
	private String name;
	private double price;
}
