package com.xworkz.login.repository;

import com.xworkz.login.dto.SigninDTO;
import com.xworkz.login.entity.LoginEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

@Repository
public class LoginRepositoryImp implements LoginRepository {
    @Override
    public boolean save(LoginEntity loginEntity) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(loginEntity);

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

    @Override
    public String getPassword(SigninDTO signinDTO) {
        String string = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            Object object = em.createNamedQuery("getPasswordName").setParameter("setName", signinDTO.getName()).getSingleResult();
            string = (String) object;
            et.commit();

        } catch (Exception e) {
            if (et.isActive())
                et.rollback();
        } finally {
            em.close();
            emf.close();
        }
        return string;
    }

    @Override
    public List<LoginEntity> getAll(String name) {

        List<LoginEntity> loginEntities = Collections.emptyList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            loginEntities = em.createNamedQuery("getAll").setParameter("setName", name).getResultList();
            System.out.println(loginEntities);
            et.commit();

        } catch (Exception e) {
            if (et.isActive())
                et.rollback();
        } finally {
            em.close();
            emf.close();
        }

        return loginEntities;
    }
}
