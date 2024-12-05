package com.xworkz.course.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.course.entity.CourseEntity;

public class CourseRunner {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query query=em.createNamedQuery("findAllById");
		query.setParameter("setId",2);
		List<CourseEntity> courseEntities=query.getResultList();
		for (CourseEntity courseEntity : courseEntities) {
			System.out.println(courseEntity);
		}
		
		System.out.println("++++++++++++++++++++++");
		Query query1=em.createNamedQuery("findAll");
		List<CourseEntity> courseEntitie=query1.getResultList();
		for (CourseEntity courseEntity1 : courseEntitie) {
			System.out.println(courseEntity1);
		}
		try {
			et.begin();
			et.commit();
		} catch (Exception e) {
			if(et.isActive())
				et.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		
	}

}
