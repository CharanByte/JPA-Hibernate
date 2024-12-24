package com.xworkz.project.repository;

import com.xworkz.project.dto.SignupDTO;
import com.xworkz.project.entity.SignupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class SignupRepositoryImp implements SignupRepository{
@Autowired
private  EntityManagerFactory entityManagerFactory;


    @Override
    public boolean save(SignupEntity signupEntity) {
        EntityManager em = entityManagerFactory.createEntityManager();
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
        }
        return true;
    }

    @Override
    public String getUserName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        String password=null;
        Object object=em.createNamedQuery("getPasswordByName").setParameter("setName",name).getSingleResult();
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
        }
        return password;
    }

    @Override
    public int checkUserName(SignupDTO signupDTO) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

       int value;
        Object object=em.createNamedQuery("getPasswordByName").setParameter("setName",signupDTO).getSingleResult();
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
        }
        return 0;
    }

    @Override
    public long getCountOfName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Long count;
        Object object=em.createNamedQuery("getCountByName").setParameter("setName",name).getSingleResult();
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
        }

        return count;
    }

    @Override
    public String[] validateUserName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();


        Object object=em.createNamedQuery("getNameByUserName").setParameter("setName",name).getSingleResult();
        String string=(String)object;
        System.out.println("username from db : "+string);

        Object object1=em.createNamedQuery("getOldPasswordByName").setParameter("setName",name).getSingleResult();
        String string1=(String)object1;
        System.out.println(string1);

        Object object2=em.createNamedQuery("getCountBYName").setParameter("setName",name).getSingleResult();
        String string2=String.valueOf(object2);
        System.out.println(string2);
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
        }

        return ref;
    }

    @Override
    public int updatePassword(String name,String newPassword) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        int value=0;

        try {
            et.begin();
             value= em.createNamedQuery("updatePassword&CountByName").setParameter("setPassword",newPassword).setParameter("setNo",0).setParameter("setName",name).executeUpdate();
            System.out.println("value from repo : "+value);
            et.commit();

        } catch (Exception e) {
            if (et.isActive())
                et.rollback();
        } finally {
            em.close();
        }

        return value;
    }

    @Override
    public Long getCountOfUserName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Long count;
        Object object=em.createNamedQuery("getCountByName").setParameter("setName",name).getSingleResult();
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
        }

        return count;
    }

    @Override
    public int getCountValue(String name, String password) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();

        int count;
        Object object=em.createNamedQuery("getCountValue").setParameter("setName",name).setParameter("setPassword",password).getSingleResult();
        count=(Integer)object;
        System.out.println("count is : "+count );
        try {
            et.begin();

            et.commit();

        } catch (Exception e) {
            if (et.isActive())
                et.rollback();
        } finally {
            em.close();
        }
        return count;
    }

    @Override
    public SignupEntity getAll(String name, String password) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        SignupEntity signupEntity = null;

        try {
            et.begin();

            List<SignupEntity> resultList = em.createNamedQuery("getAll", SignupEntity.class)
                    .setParameter("getName", name)
                    .getResultList();

            if (!resultList.isEmpty()) {
                signupEntity = resultList.get(0);
            }

            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

        return signupEntity;
    }

    @Override
    public int updateCountBy1(String name, int loginCount) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
      int updateValue=0;

        try {
            et.begin();

          updateValue = em.createNamedQuery("updateCountValue").setParameter("setName", name).setParameter("setNo",loginCount).executeUpdate();

            System.out.println("updateValue  "+updateValue);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return updateValue;
    }


}
