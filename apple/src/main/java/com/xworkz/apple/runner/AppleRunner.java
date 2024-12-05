package com.xworkz.apple.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.apple.dto.AppleDTO;

public class AppleRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

//	List<AppleDTO> list	=em.createQuery("select a from AppleDTO a").getResultList();
//	for (AppleDTO appleDTO : list) {
//		
//		System.out.println(appleDTO);
//	}
		Query query = em.createNamedQuery("findAll");
		Object object = query.getSingleResult();

		AppleDTO appleDTO = (AppleDTO) object;
		System.out.println(appleDTO.toString());

		Query query2 = em.createNamedQuery("findNameByPhone");
		Object object2 = query2.getSingleResult();
		String string = (String) object2;
		System.out.println(string);

		Query query3 = em.createNamedQuery("findEmailById");
		Object object3 = query3.getSingleResult();
		String string1 = (String) object3;
		System.out.println(string1);

		Query query4 = em.createNamedQuery("findPhoneNoById");
		Object object4 = query4.getSingleResult();
		String string2 = (String) object4;
		System.out.println(string2);

		Query query5 = em.createNamedQuery("findAgeByName");
		Object object5 = query5.getSingleResult();
		Integer string3 = (Integer) object5;
		System.out.println(string3);
		try {

			et.begin();

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
