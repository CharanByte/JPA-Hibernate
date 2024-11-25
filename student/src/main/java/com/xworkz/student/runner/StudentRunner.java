package com.xworkz.student.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.student.dto.StudentDto;

public class StudentRunner {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		try {
			et.begin();
			StudentDto studentDto=new StudentDto();
			studentDto.setId(1);
			studentDto.setName("raju");
			studentDto.setAge(22);
			
			studentDto.setId(2);
			studentDto.setName("charan");
			studentDto.setAge(23);
			
			studentDto.setId(2);
			studentDto.setName("sachin");
			studentDto.setAge(24);
		
			
//			em.persist(studentDto);
			em.merge(studentDto);
			et.commit();
		} catch (Exception e) {
			
		}
		finally {
			em.close();
			emf.close();
		}
	
	}

}