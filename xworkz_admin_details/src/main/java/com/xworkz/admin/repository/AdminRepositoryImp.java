package com.xworkz.admin.repository;

import com.xworkz.admin.entity.AdminEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class AdminRepositoryImp implements AdminRepository{
    @Override
    public boolean save(AdminEntity adminEntity) {
        EntityManagerFactory  emf =Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
    EntityTransaction et =em.getTransaction();

        try {
            et.begin();
            em.persist(adminEntity);

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
