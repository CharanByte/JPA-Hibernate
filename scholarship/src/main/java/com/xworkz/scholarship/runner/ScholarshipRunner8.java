package com.xworkz.scholarship.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.scholarship.entity.ScholarshipEntity;

public class ScholarshipRunner8 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			List<ScholarshipEntity> list = em.createNamedQuery("getAllByEmailAndNumber")
					.setParameter("setemail", "charan@gmail.com").setParameter("setNo", 9741591749L).getResultList();
			for (ScholarshipEntity scholarshipEntity : list) {
				System.out.println(scholarshipEntity);
			}
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
