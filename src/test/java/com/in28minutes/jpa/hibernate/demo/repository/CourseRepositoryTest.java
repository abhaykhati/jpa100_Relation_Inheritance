package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Demo2Application;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Demo2Application.class)
public class CourseRepositoryTest {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	

/*	@Test
	public void findByIdTest() {
		Course findByID = repository.findByID(10001L);
		assertEquals("JPA IN 50 STEPS", findByID.getName());
	}*/
	
	@Test
	@DirtiesContext
	public void deleteByIdTest() {
		repository.deleteById(10004l);
		assertNull(repository.findByID(10004l));
	}
	
	@Test
	public void findByIdTest() {
		Course findByID = repository.findByID(10001L);
		assertEquals("JPA IN 50 STEPS", findByID.getName());
	}
	
	
	@Test
	@DirtiesContext
	public void insertTest() {
		Course course = repository.findByID(10001l);
		assertEquals("JPA IN 50 STEPS", "JPA IN 50 STEPS");
		course.setName("JPA IN 50 STEPS- > UPDATED");
		repository.insert(course);
		
		Course course2 = repository.findByID(10001l);
		assertEquals("JPA IN 50 STEPS- > UPDATED", course2.getName());
	}
	
	

}
