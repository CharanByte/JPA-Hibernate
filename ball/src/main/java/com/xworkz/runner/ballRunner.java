package com.xworkz.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.dto.BallDTO;

public class ballRunner {

	public static void main(String[] args) {
	
	EntityManagerFactory emf=	Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	try {
		et.begin();
		BallDTO ballDTO=new BallDTO();
		ballDTO.setId(1);
		ballDTO.setName("vicky");
		ballDTO.setCost(80);
		em.persist(ballDTO);
		et.commit();
	} catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		em.close();
		emf.close();
	}
	}

}
