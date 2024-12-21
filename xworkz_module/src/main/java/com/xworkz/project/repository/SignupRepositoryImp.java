package com.xworkz.project.repository;

import com.xworkz.project.dto.SigninDTO;
import com.xworkz.project.dto.SignupDTO;
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

    @Override
    public String getUserName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        String password=null;
        Object object=em.createNamedQuery("getPassword").setParameter("setName",name).getSingleResult();
       password=(String) object;
        System.out.println("password fom db : "+password);
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
        return password;
    }

    @Override
    public int checkUserName(SignupDTO signupDTO) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

       int value;
        Object object=em.createNamedQuery("getPassword").setParameter("setName",signupDTO).getSingleResult();
       // password=(String) object;
       // System.out.println("password fom db : "+password);
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
        return 0;
    }

    @Override
    public long getCountOfName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Long count;
        Object object=em.createNamedQuery("getCount").setParameter("setName",name).getSingleResult();
      count=(Long)object;
        System.out.println("count is : "+count );
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

        return count;
    }


}
