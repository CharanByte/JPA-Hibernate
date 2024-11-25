package com.xworkz.movie.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.movie.dto.MovieDto;


public class Movierunner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			MovieDto movieDto =new MovieDto();
					movieDto.setId(1);
			movieDto.setHeroName("yash");
			movieDto.setBudget(50000000);
			em.persist(movieDto);
			et.commit();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
			emf.close();

		}


	}

}
