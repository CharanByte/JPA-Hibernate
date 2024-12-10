package com.xworkz.railway.repo;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RailwayRepositoryImp implements RailwayRepository {

	@Override
	public long getPhoneNoById(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Object object = em.createNamedQuery("getPhonenumberById").setParameter("setid", id).getSingleResult();
		Long long1 = (Long) object;

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
		return long1;
	}

	@Override
	public List<String> getNameByAge(int age) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		List<String> list = em.createNamedQuery("getNameByAge").setParameter("setAge", age).getResultList();

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
	public Date getDobByphno(long no) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Object object = em.createNamedQuery("getDobByphno").setParameter("phno", no).getSingleResult();
		Date date = (Date) object;
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
		return date;
	}

	@Override
	public String getAddressandName(int id, String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Object object = em.createNamedQuery("getAddress&Name").setParameter("setid", id).setParameter("setname", name)
				.getSingleResult();
		String address = (String) object;
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
		return address;
	}

}
