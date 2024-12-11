package com.xworkz.holiday.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="holiday_table")
@ToString
@NoArgsConstructor

@NamedQuery(name = "getAll",query = "select a from HolidayEntity a where a.id=:setId")
@NamedQuery(name = "getlocationNameByPhoneNo" ,query = "select a.location from HolidayEntity a where a.name=:setname and a.phoneNo=:setNo")
public class HolidayEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	private double cost;
	private long phoneNo;
	public HolidayEntity(String name, String location, double cost, long phoneNo) {
		super();
		this.name = name;
		this.location = location;
		this.cost = cost;
		this.phoneNo = phoneNo;
	}
	

}
