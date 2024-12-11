package com.xworkz.holiday.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.holiday.entity.HolidayEntity;

public class HolidayRepositoryImp implements HolidayRepository {

	@Override
	public List<HolidayEntity> getAllById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		List<HolidayEntity> list = em.createNamedQuery("getAll").setParameter("setId", id).getResultList();

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

		return list;
	}

	@Override
	public String getlocationNameByPhoneNo(String name, long no) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Object object = em.createNamedQuery("getlocationNameByPhoneNo").setParameter("setname", name)
				.setParameter("setNo", no).getSingleResult();
		String string = (String) object;
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

		return string;
	}

}
