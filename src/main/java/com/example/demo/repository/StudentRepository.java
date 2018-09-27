package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Passport;
import com.example.demo.entity.Student;

@Repository
@Transactional //use spring transaction management rather than 
//java.transaction.Transactional because spring transaction supports multiple databases at the same time

public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void studentWithPassport() {

		Passport passport = new Passport();
		passport.setNumber("Z8384957");
		em.persist(passport);

		Student student = new Student();
		student.setName("MIKE");
		student.setPassport(passport);
		em.persist(student);

	}

	public void getStudentAndPassportDetails() {

		Student find = em.find(Student.class, 20001l);
		System.out.println("Student Name=   " + find.getName().toString());
		System.out.println("Passport number=  " + find.getPassport().getNumber());

	}

	public void getPassportAndStudentDetails() {

		Passport find = em.find(Passport.class, 40001L);
		System.out.println("Passport number=   " + find.getNumber());
		System.out.println("Student name=  " + find.getStudent().getName().toString());

	}

	public void getStudentAndRelatedCourses() {
		Student student = em.find(Student.class, 20001L);
		System.out.println("student Name=  " + student.getName());
		System.out.println("Student is having these courses=    " + student.getCourses());
	}

	public void insertStudentAndMultipleCourses(Student student) {

		em.persist(student);
	}

	public void joinForStudentAndCourses() {
		Query createQuery = em.createQuery("Select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = createQuery.getResultList();
		logger.info("Size of Result list =  " + resultList.size());

		for (Object[] result : resultList) {

			logger.info("Course{}, Student{} ", result[0], result[1]);
		}

	}
	
	public void leftJoinForStudentAndCourses() {
		Query createQuery = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = createQuery.getResultList();
		logger.info("Size of Result list =  " + resultList.size());

		for (Object[] result : resultList) {

			logger.info("Course{}, Student{} ", result[0], result[1]);
		}

	}
	
	public void crossJoinForStudentAndCourses() {
		Query createQuery = em.createQuery("Select c, s from Course c, Student s");
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = createQuery.getResultList();
		logger.info("Size of Result list =  " + resultList.size());

		for (Object[] result : resultList) {

			logger.info("Course{}, Student{} ", result[0], result[1]);
		}
	}
	
	
	
	
	
	
	
	
	/*
	 * public void insertIntoStudentAndCourse() {
	 * 
	 * Course course1=new Course(); course1.setName("power builder in 2 steps");
	 * 
	 * Course course2=new Course(); course2.setName("Javascript in 100 steps");
	 * 
	 * List<Course> courseList=new ArrayList<>(); courseList.add(course1);
	 * courseList.add(course2);
	 * 
	 * Student student1=new Student(); student1.setName("vishal");
	 * 
	 * Student student2=new Student(); student2.setName("Sarang");
	 * 
	 * List<Student> studentList=new ArrayList<>(); studentList.add(student1);
	 * studentList.add(student2);
	 * 
	 * student1.setCourses(courseList); student2.setCourses(courseList);
	 * 
	 * course1.setStudents(studentList);
	 * 
	 * for(Student s:studentList) { em.persist(s); }
	 * 
	 * sem.persist(student1); em.persist(student2);
	 * 
	 * em.persist(course1); em.persist(course2);
	 * 
	 * }
	 */

	/*
	 * public void insetEmployeeAndProject() {
	 * 
	 * Employee prasad = new Employee(); prasad.setName("prasad kharkar");
	 * 
	 * Employee harish = new Employee(); harish.setName("Harish taware");
	 * 
	 * Project ceg = new Project(); ceg.setName("CEG");
	 * 
	 * Project gtt = new Project(); gtt.setName("GTT");
	 * 
	 * List<Project> projectsList = new ArrayList<Project>(); projectsList.add(ceg);
	 * projectsList.add(gtt);
	 * 
	 * List<Employee> employeesList = new ArrayList<Employee>();
	 * employeesList.add(prasad); employeesList.add(harish);
	 * 
	 * ceg.setEmployees(employeesList); gtt.setEmployees(employeesList);
	 * 
	 * prasad.setProjects(projectsList); harish.setProjects(projectsList);
	 * 
	 * em.persist(prasad); }
	 */

}
