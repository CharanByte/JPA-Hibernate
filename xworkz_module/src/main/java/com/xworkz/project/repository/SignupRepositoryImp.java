package com.xworkz.project.repository;

import com.xworkz.project.dto.PasswordResetDTO;
import com.xworkz.project.dto.SigninDTO;
import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.entity.SignupEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

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

    @Override
    public String[] validateUserName(PasswordResetDTO passwordResetDTO) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();


        Object object=em.createNamedQuery("getUserName").setParameter("setName",passwordResetDTO.getName()).getSingleResult();
        String string=(String)object;
        System.out.println("username from db : "+string);

        Object object1=em.createNamedQuery("getOldPassword").setParameter("setName",passwordResetDTO.getName()).getSingleResult();
        String string1=(String)object1;
        System.out.println(string1);

        Object object2=em.createNamedQuery("getNo").setParameter("setName",passwordResetDTO.getName()).getSingleResult();
        String string2=String.valueOf(object2);
        System.out.println(string1);
        String[] ref={string,string1,string2};
        System.out.println("repo"+ref[0]+ " "+ref[1]+ " "+ref[2]);
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

        return ref;
    }

    @Override
    public int updatePassword(PasswordResetDTO passwordResetDTO) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        int value=0;

        try {
            et.begin();
             value= em.createNamedQuery("updatepassword").setParameter("setPassword",passwordResetDTO.getNewPassword()).setParameter("setNo",0).setParameter("setName",passwordResetDTO.getName()).executeUpdate();
            System.out.println("value from repo : "+value);
            et.commit();

        } catch (Exception e) {
            if (et.isActive())
                et.rollback();
        } finally {
            em.close();
            emf.close();
        }

        return value;
    }


}
