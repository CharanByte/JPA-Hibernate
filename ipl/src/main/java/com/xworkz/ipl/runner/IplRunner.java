package com.xworkz.ipl.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.ipl.dto.IplDto;

public class IplRunner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			IplDto iplDto1 = new IplDto("rcb", "virat", 11);

			IplDto iplDto2 = new IplDto("csk", "Ruturaj", 11);
			IplDto iplDto3 = new IplDto("dc", "Pant", 11);
			IplDto iplDto4 = new IplDto("gt", "gill", 11);
			IplDto iplDto5 = new IplDto("kkr", "Iyer", 11);
			IplDto iplDto6 = new IplDto("lsg", "rahul", 11);
			IplDto iplDto7 = new IplDto("pks", "Dhawan", 11);
			IplDto iplDto8 = new IplDto("rr", "sanju", 11);
			IplDto iplDto9 = new IplDto("srh", "cummins", 11);
			IplDto iplDto10 = new IplDto("mi", "Hardik", 11);

			em.persist(iplDto10);
			et.commit();

		} catch (Exception e) {

		}

		finally {
			em.close();
			emf.close();
		}
	}

}
