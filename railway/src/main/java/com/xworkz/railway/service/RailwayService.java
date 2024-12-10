package com.xworkz.railway.service;

import java.sql.Date;
import java.util.List;

public interface RailwayService {
	
	long getPhoneNoById(int id);
	
	List<String> getNameByAge(int age);
	
	 Date getDobByphno(long phoneNo);

}
