package com.xworkz.college.operations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.college.dto.CollegeDto;

public class CollegeOperations {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			CollegeDto collegeDto = new CollegeDto();
			int value = em.createQuery(
					"update CollegeDto table set table.name=:setname ,table.email=:setemail where table.phoneNo=:setphoneNo")
					.setParameter("setname", "charan jv").setParameter("setemail", "charanjv@gmail.com")
					.setParameter("setphoneNo", "9741591749").executeUpdate();

			if (value > 0)
				System.out.println("updated");

			else
				System.err.println("error");

			System.out.println("=================================");

			List<CollegeDto> list = em.createQuery("select a from CollegeDto a", CollegeDto.class).getResultList();

			for (CollegeDto collegeDto2 : list) {
				System.out.println(collegeDto2);

			}
			
			System.out.println("=================================");
		List<CollegeDto> list2=	em.createQuery("select u.name,u.email from CollegeDto u where u.age>=23", CollegeDto.class).getResultList();
		for (CollegeDto collegeDto2 : list2) {
			System.out.println(collegeDto2.getName());
		}
			
			et.commit();

		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}

}
