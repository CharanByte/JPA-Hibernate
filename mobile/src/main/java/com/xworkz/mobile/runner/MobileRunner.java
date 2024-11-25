package com.xworkz.mobile.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.mobile.dto.MobileDto;

public class MobileRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			MobileDto mobileDto = new MobileDto();
			mobileDto.setId(1);
			mobileDto.setName("mi");
			mobileDto.setPrice(10000);
			em.persist(mobileDto);
			et.commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
			emf.close();

		}

	}

}
