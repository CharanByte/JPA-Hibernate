package com.xworkz.course.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CourseRunner3 {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query2 = em.createNamedQuery("findNameById").setParameter("setid", 2);
		Object object = query2.getSingleResult();
		String string = (String) object;
		System.out.println(string);

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
