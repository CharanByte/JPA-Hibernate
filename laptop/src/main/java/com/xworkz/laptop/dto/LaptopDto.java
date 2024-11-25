package com.xworkz.laptop.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="laptop_table")
public class LaptopDto {
	@Id
	private int id;
	private String name;
	private double price;

}
