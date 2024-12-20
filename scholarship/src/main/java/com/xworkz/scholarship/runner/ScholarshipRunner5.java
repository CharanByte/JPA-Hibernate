package com.xworkz.scholarship.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ScholarshipRunner5 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
			List<Object[]> list=em.createNamedQuery("getNameAndEmailById").setParameter("setId",6).getResultList();
			for (Object[] objects : list) {
				System.out.println("name : "+objects[0]+"  email : "+objects[1]);
			}
			
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
