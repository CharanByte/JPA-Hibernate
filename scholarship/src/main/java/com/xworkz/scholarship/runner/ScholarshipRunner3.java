package com.xworkz.scholarship.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ScholarshipRunner3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			int value = em.createNamedQuery("updateAge").setParameter("setAge", 25).setParameter("setNo", 7651591749L)
					.setParameter("setisEligible", true).executeUpdate();

			if (value > 0)
				System.out.println("age updated");
			else
				System.err.println("not updated");
			et.commit();

		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}

}
