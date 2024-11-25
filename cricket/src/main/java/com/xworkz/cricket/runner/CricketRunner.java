package com.xworkz.cricket.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.cricket.dto.CricketDto;

public class CricketRunner {

	public static void main(String[] args) {
		
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager	em=	emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	try {
		et.begin();
		CricketDto cricketDto=new CricketDto();
		cricketDto.setId(1);
		cricketDto.setName("virat");
		cricketDto.setPlayersNo(18);
		em.persist(cricketDto);
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
