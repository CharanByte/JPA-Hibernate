package com.xworkz.holiday.runner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.holiday.entity.HolidayEntity;
import com.xworkz.holiday.service.HolidayServiceImp;

public class HolidayRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		List<HolidayEntity> list = new ArrayList<HolidayEntity>();
		list.add(new HolidayEntity("charan", "kolar", 400.0, 9741591749L));
		list.add(new HolidayEntity("arun", "bengaluru", 700.0, 8776253623L));
		list.add(new HolidayEntity("ajay", "bagalkot", 900.0, 7838838833L));
		list.add(new HolidayEntity("sachin", "hubli", 725.0, 9736654372L));
		list.add(new HolidayEntity("nandan", "kgf", 730.0, 8376376373L));

		for (HolidayEntity holidayEntity : list) {
			// em.persist(holidayEntity);
		}

		try {
			et.begin();

			et.commit();

		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
		} finally {
			em.close();
			emf.close();
		}

		HolidayServiceImp holidayServiceImp = new HolidayServiceImp();
		List<HolidayEntity> ref = holidayServiceImp.getAllById(1);
		for (HolidayEntity holidayEntity : ref) {
			System.out.println(holidayEntity);
		}

		String ref1 = holidayServiceImp.getlocationNameByPhoneNo("charan", 9741591749L);
		System.out.println(ref1);
	}

}
