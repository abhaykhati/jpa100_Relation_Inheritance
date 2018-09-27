package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.MappedSuperclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Course;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.PartTimeEmployee;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class Demo2Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courserepository;

	@Autowired
	private StudentRepository studentrepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	employeeRepository.insert(new FullTimeEmployee("Abhay", new BigDecimal("10000")));
		
		employeeRepository.insert(new PartTimeEmployee("Anand", new BigDecimal("50")));
		
		logger.info(" PartTimeEmployee=   "+ employeeRepository.getPartTimeEmployee());// in case of @MappedSuperclass
		logger.info(" FullTimeEmployee=   "+ employeeRepository.getFullTimeEmployee()); //in case of @MappedSuperclass
		
		*/
		
	       // due to @MappedSuperclass since employee is not an Entity anymore in this case
		// logger.info(" All Employees=   "+ employeeRepository.getAllEmployees());
    
		
	//=======================================================================================	
		
		studentrepository.joinForStudentAndCourses();
		
		studentrepository.leftJoinForStudentAndCourses();
		
		studentrepository.crossJoinForStudentAndCourses();
		

		/*
		 * Course course = repository.findByID(10001l);
		 * logger.info("course 10001{}->   ", course.getName()); repository.insert(new
		 * Course("Microservices IN 100 STEPS"));
		 */

		// courserepository.playWithEntityManager();
		// courserepository.getAllCourseNames();
		// courserepository.playWithEntityManager();
		// studentrepository.studentWithPassport();
		// studentrepository.getStudentAndPassportDetails();
		// studentrepository.getPassportAndStudentDetails();

		//courserepository.addHardCodedReviewsForCourses();
		
		/*List<Review> reviewList=new ArrayList<>();
		reviewList.add(new Review(4L, "Bakwas Course"));
		reviewList.add(new Review(5L, "Good Coourse to learn JPA"));
		courserepository.addReviewsForCourses(10003L, reviewList);*/
		
		//studentrepository.getStudentAndRelatedCourses();
		
	
		
	/*	Course course1=new Course();
		course1.setName("power builder in 2 steps");
		List<Course> courseList=new ArrayList<>();
		courseList.add(course1);
		
		Student student1=new Student();
		student1.setName("vishal");
		List<Student> studentList=new ArrayList<>();
		studentList.add(student1);
		course1.setStudents(studentList);
		student1.setCourses(courseList); */
		
	
		
		//studentrepository.insertIntoStudentAndCourse();
	//	studentrepository.insetEmployeeAndProject();
		
		
		/*Student student =new Student();
		student.setName("Akhilesh");
		
		Course course1=new Course();
		course1.setName("Windows XP in 10 Steps");
		
		Course course2=new Course();
		course2.setName("Android in 50 steps");
		
		List<Course> courseList=new ArrayList<>();
		courseList.add(course1);
		courseList.add(course2);
		
		student.setCourses(courseList);
		course1.addStudents(student);
		course2.addStudents(student);*/
		
		
	//	studentrepository.insertStudentAndMultipleCourses(student);
		
	}
}