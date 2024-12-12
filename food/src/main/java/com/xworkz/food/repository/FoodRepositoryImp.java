package com.xworkz.food.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.xworkz.food.entity.FoodEntity;

@Repository
public class FoodRepositoryImp implements FoodRepository {

	@Override
	public boolean save(FoodEntity foodEntity) {
		System.out.println("foodEntity in repo : " + foodEntity);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(foodEntity);

			et.commit();

		} catch (Exception e) {
			if (et.isActive())
				et.rollback();
		} finally {
			em.close();
			emf.close();
		}
		return false;
	}

}
