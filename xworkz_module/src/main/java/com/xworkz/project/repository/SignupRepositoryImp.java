package com.xworkz.project.repository;

import com.xworkz.project.entity.SignupEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class SignupRepositoryImp implements SignupRepository{

    @Override
    public boolean save(SignupEntity signupEntity) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(signupEntity);
            et.commit();

        } catch (Exception e) {
            if (et.isActive())
                et.rollback();
        } finally {
            em.close();
            emf.close();
        }
        return true;
    }


}
