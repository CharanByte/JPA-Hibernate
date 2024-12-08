package com.xworkz.scholarship.runner;

import javax.persistence.*;

public class ScholarshipRunner6 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			et.commit();

		} catch (Exception e) {
			if(et.isActive())
				et.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}

}
