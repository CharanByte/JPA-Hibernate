package com.xworkz.college.operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.college.dto.CollegeDto;

public class CollegeRead {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			CollegeDto collegeDto = new CollegeDto();

			List<CollegeDto> list = em.createQuery("select a from CollegeDto a", CollegeDto.class).getResultList();

			for (CollegeDto collegeDto2 : list) {
				System.out.println(collegeDto2);

			}

			System.out.println("=================================");
			List<CollegeDto> list2 = em
					.createQuery("select a from CollegeDto a where a.age>15").getResultList();
			for (CollegeDto collegeDto2 : list2) {
				System.out.println(collegeDto2.getName() +" "+collegeDto2.getEmail());
			}
			
			System.out.println("=================================");
			List<String> list3 = em
					.createQuery(
							"select u.email from CollegeDto u where u.name like : setname OR u.name like :setname1 ")
					.setParameter("setname", "s%").setParameter("setname1", "n%").getResultList();
			for (String string : list3) {
				System.out.println(string);
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
