package com.xworkz.railway.service;

import java.sql.Date;
import java.util.List;

import com.xworkz.railway.repo.RailwayRepository;
import com.xworkz.railway.repo.RailwayRepositoryImp;

public class RailwayServiceImp implements RailwayService{

	@Override
	public long getPhoneNoById(int id) {
		RailwayRepository railwayRepositoryImp=new RailwayRepositoryImp();
		Long phNo=railwayRepositoryImp.getPhoneNoById(id);
		return phNo;
	}

	@Override
	public List<String> getNameByAge(int age) {
		RailwayRepository railwayRepositoryImp=new RailwayRepositoryImp();
		List<String> name=railwayRepositoryImp.getNameByAge(age);
		return name;
	}

	@Override
	public Date getDobByphno(long phoneNo) {
		RailwayRepository railwayRepositoryImp=new RailwayRepositoryImp();
		Date dob=railwayRepositoryImp.getDobByphno(phoneNo);
		return dob;
	}

}
