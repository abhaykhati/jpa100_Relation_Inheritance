package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;
import com.example.demo.entity.Review;
import com.example.demo.entity.ReviewRating;

@Repository
@Transactional
//use spring transaction management rather than 
//java.transaction.Transactional because spring transaction supports multiple databases at the same time

public class CourseRepository {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	public Course findByID(Long id) {
		return em.find(Course.class, id);
	}

	
   public void  getAllCourseNames(){
	   TypedQuery<Course> createNamedQuery = em.createQuery("SELECT c FROM Course c",Course.class);
	   
	   
	   /*TypedQuery<Course> createNamedQuery = em.createQuery("SELECT c FROM Course c where name like '%100 Steps' ",Course.class);*/
	   List<Course> resultList = createNamedQuery.getResultList();
	   for(Course c:resultList) {
		   String name = c.getName();
		   System.out.println(name);
	   }
   }

	public void deleteById(Long id) {
		Course findByID = findByID(id);
		em.remove(findByID);
	}

	public Course insert(Course course) {
		if (course.getId() == null) {

			em.persist(course);
		} else {
			em.merge(course);
		}

		return course;
	}

	public void playWithEntityManager() {

	/*	Course c1=new Course("web services in 100 steps");
		em.persist(c1);
		em.flush();
		Course findByID = findByID(10001L);
		findByID.setName("JPA IN 50 STEPS -    -----> UPDATED");
		em.persist(findByID);
		em.flush();*/
		
		
		
		
		/*Course course1 = new Course("web services in 100 steps");
		em.persist(course1);

		Course course2 = new Course("Angular JS 100 steps");
		em.persist(course2);

		em.flush();
		// em.clear ();

		// em.detach(course2); // or use em.clear ()

		course1.setName("web services in 100 steps- UPDATED");
		course2.setName("Angular JS 100 steps- UPDATED");
		em.refresh(course2);
		em.flush();*/

	}


	public void addReviewsForCourses(Long courseID, List<Review> reviews) {
		//getting the course
		Course course = findByID(courseID);
		
		for(Review r:reviews) {
			
			course.addReviews(r);
			r.setCourse(course);
			em.persist(r);
		}
		
	}
	
	public void addHardCodedReviewsForCourseUsingEnum() {
		
		Course course=findByID(10003L);
		logger.info("course.getReviews=  ", course.getReviews());
		
		// add 2 reviews to course
		Review review= new Review(ReviewRating.FIVE, "great hands-on-stuff");
		Review review2= new Review(ReviewRating.THREE, "OK COURSE,NOTHING NEW TO LEARN");
	}
	
	/*public void addHardCodedReviewsForCourses() {
		//getting the course
		Course course = findByID(10003L);
		
		//List<Review> reviews = course.getReviews();
		//creating 2 reviews
		Review review1=new Review(5l, "Great,Hands -on- Stuff");
		Review review2=new Review(2l, "OK Course");
		
		//setting the relationship
		course.addReviews(review1);
		review1.setCourse(course);	
		
		
		course.addReviews(review2);
		review2.setCourse(course);
		
		//saving to the database
		em.persist(review1);
		em.persist(review2);
		
	}*/

}
