package com.xworkz.scholarship.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ScholarshipRunner7 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			
		 List<Object[]> object=	em.createNamedQuery("getNameEmailPhoneNoById").setParameter("setId",3).getResultList();
		 for (Object[] objects : object) {
				System.out.println("name : "+objects[0]+" email : "+objects[1]+" number : "+objects[2]);
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
