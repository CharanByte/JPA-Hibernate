package com.xworkz.ipl.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.ipl.dto.IplDto;

public class IplDelRunner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			IplDto iplDto = new IplDto();
			for (int i = 5; i < 11; i++) {
				IplDto value = em.find(IplDto.class, i);
				em.remove(value);
			}
			et.commit();

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
		}

		finally {
			em.close();
			emf.close();

		}
	}
}
