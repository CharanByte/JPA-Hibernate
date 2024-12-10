package com.xworkz.railway.runner;

import java.sql.Date;
import java.util.List;

import com.xworkz.railway.service.RailwayService;
import com.xworkz.railway.service.RailwayServiceImp;

public class RailwayRunner {

	public static void main(String[] args) {

		RailwayService imp = new RailwayServiceImp();
		Long phNo = imp.getPhoneNoById(2);
		System.out.println(phNo);

		List<String> name = imp.getNameByAge(23);
		for (String string : name) {
			System.out.println(string);
		}

		Date dob = imp.getDobByphno(9741591749L);
		System.out.println(dob);

		String address = imp.getAddressAndName(1, "charan jv");
		System.out.println(address);
	}

}
