package com.xworkz.holiday.service;

import java.util.List;

import com.xworkz.holiday.entity.HolidayEntity;

public interface HolidayService {
	
	List<HolidayEntity> getAllById(int id);
	
	String getlocationNameByPhoneNo(String name,long no);

}
