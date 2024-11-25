package com.xworkz.laptop.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.laptop.dto.LaptopDto;

public class LaptopRunner {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		try {
			et.begin();
			LaptopDto laptopDto=new LaptopDto();
			laptopDto.setId(1);
			laptopDto.setName("dell");
			laptopDto.setPrice(50000);
			em.persist(laptopDto);
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
