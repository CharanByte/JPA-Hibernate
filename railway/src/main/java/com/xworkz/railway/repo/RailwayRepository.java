package com.xworkz.railway.repo;

import java.sql.Date;
import java.util.List;

public interface RailwayRepository {

	long getPhoneNoById(int id);

	List<String> getNameByAge(int age);

	Date getDobByphno(long no);

	String getAddressandName(int id, String name);

}
