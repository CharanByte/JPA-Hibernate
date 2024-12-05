package com.xworkz.course.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CourseRunner4 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query3 = em.createNamedQuery("findAgeByname").setParameter("findNameById", "charan");
		Object object1 = query3.getSingleResult();
		Integer string1 = (Integer) object1;
		System.out.println(string1);
		
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

	}

}
