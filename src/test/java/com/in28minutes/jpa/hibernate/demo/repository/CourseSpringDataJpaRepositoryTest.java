package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Demo2Application;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseSpringDataJpaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo2Application.class)
public class CourseSpringDataJpaRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataJpaRepository repository;

	/*@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		assertFalse(courseOptional.isPresent());
	}

	@Test
	public void courseInsertAndUpdate() {

		Course course = new Course("MicroServices in 100 Steps");
		repository.save(course);

		course.setName("MicroServices in 100 Steps- Updated");
		repository.save(course);

	}
*/
	@Test
	public void getAllCoursesAndCountAndSort() {
		logger.info("All Sorted Courses=   " + repository.findAll(Sort.by("name").descending()));
		logger.info("Count of Courses =    " + repository.count());
	}

}
