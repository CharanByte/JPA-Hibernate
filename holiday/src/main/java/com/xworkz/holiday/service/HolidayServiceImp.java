package com.xworkz.holiday.service;

import java.util.List;

import com.xworkz.holiday.entity.HolidayEntity;
import com.xworkz.holiday.repository.HolidayRepository;
import com.xworkz.holiday.repository.HolidayRepositoryImp;

public class HolidayServiceImp implements HolidayService {

	@Override
	public List<HolidayEntity> getAllById(int id) {
		HolidayRepository holidayRepositoryImp = new HolidayRepositoryImp();
		List<HolidayEntity> ref = holidayRepositoryImp.getAllById(id);
		return ref;
	}

	@Override
	public String getlocationNameByPhoneNo(String name, long no) {
		HolidayRepository holidayRepositoryImp = new HolidayRepositoryImp();
		String ref = holidayRepositoryImp.getlocationNameByPhoneNo(name, no);
		return ref;
	}

}
