package com.xworkz.scholarship.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ScholarshipRunner9 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			int value = em.createNamedQuery("deleteByNameAndAge").setParameter("setname", "sachin")
					.setParameter("setAge", 23).executeUpdate();

			if(value>0)
				System.out.println("deleted");
			else
				System.err.println("not deleted");
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
