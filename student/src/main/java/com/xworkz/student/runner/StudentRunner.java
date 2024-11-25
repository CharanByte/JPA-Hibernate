package com.xworkz.student.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.student.dto.StudentDto;
import com.xworkz.student.dto.TeacherDto;

public class StudentRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			StudentDto studentDto = new StudentDto();
			studentDto.setId(1);
			studentDto.setName("raju");
			studentDto.setAge(22);

			studentDto.setId(2);
			studentDto.setName("charan");
			studentDto.setAge(23);

			studentDto.setId(2);
			studentDto.setName("sachin");
			studentDto.setAge(24);

//			em.persist(studentDto);
			em.merge(studentDto);

			TeacherDto teacherDto = new TeacherDto();
			teacherDto.setId(1);
			teacherDto.setName("nandan");
			teacherDto.setAge(47);
			teacherDto.setSubject("maths");

			teacherDto.setId(1);
			teacherDto.setName("ravi");
			teacherDto.setAge(47);
			teacherDto.setSubject("maths");

			em.merge(teacherDto);
			et.commit();
		} catch (Exception e) {

		} finally {
			em.close();
			emf.close();
		}

	}

}
