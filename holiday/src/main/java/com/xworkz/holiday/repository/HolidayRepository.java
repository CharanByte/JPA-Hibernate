package com.xworkz.holiday.repository;

import java.util.List;

import com.xworkz.holiday.entity.HolidayEntity;

public interface HolidayRepository {

	List<HolidayEntity> getAllById(int id);
	
	String getlocationNameByPhoneNo(String name,long no);
}
