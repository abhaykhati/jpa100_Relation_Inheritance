package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Course;

@Repository
@Transactional
//use spring transaction management rather than 
//java.transaction.Transactional because spring transaction supports multiple databases at the same time
public class CriteriaQueryRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void CriteriaBasic() {

		// step 1: use criteria builder to create a criteria query returning expected
		// result objects
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// step 2: define roots for tables which are involved in query
		Root<Course> courseRoot = cq.from(Course.class);

		TypedQuery<Course> createQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = createQuery.getResultList();

		logger.info("Typed Query for Courses List=   " + resultList);
	}
	
	public void allCoursesHaving100Steps() {

		// select c from course c where name like '100%steps'
		
		// step 1: use criteria builder to create a criteria query returning expected
		// result objects
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// step 2: define roots for tables which are involved in query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//step 3: define predicate using  criteria query
		Predicate like = cb.like(courseRoot.get("name"), "%100 Steps");
		
		//step 4: add predicates  to the criteria query
		cq.where(like);
		

		TypedQuery<Course> createQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = createQuery.getResultList();

		logger.info("Typed Query for Courses List=   " + resultList);
	}
	
	public void allCoursesWithoutStudents() {

		// select c from course c where c.students is empty
		
		// step 1: use criteria builder to create a criteria query returning expected
		// result objects
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// step 2: define roots for tables which are involved in query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//step 3: define predicate using  criteria query
		Predicate studentIsEmpty = cb.like(courseRoot.get("name"), "%100 Steps");
		
		//step 4: add predicates  to the criteria query
		cq.where(studentIsEmpty);
		

		TypedQuery<Course> createQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = createQuery.getResultList();

		logger.info("Typed Query for Courses List=   " + resultList);
	}
	
	public void courseAndStiudentJoin() {

		// select c from course c join  where c.students s
		
		// step 1: use criteria builder to create a criteria query returning expected
		// result objects
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// step 2: define roots for tables which are involved in query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//step 3: define predicate using  criteria query
		Join<Object, Object> join = courseRoot.join("students");
		
		//step 4: add predicates  to the criteria query
		

		TypedQuery<Course> createQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = createQuery.getResultList();

		logger.info("Typed Query for Courses List=   " + resultList);
	}
	
	
	public void courseAndStiudentLeftJoin() {

		// select c from course c left join  where c.students s
		
		// step 1: use criteria builder to create a criteria query returning expected
		// result objects
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// step 2: define roots for tables which are involved in query
		Root<Course> courseRoot = cq.from(Course.class);
		
		//step 3: define predicate using  criteria query
		Join<Object, Object> join = courseRoot.join("students",JoinType.LEFT);
		
		//step 4: add predicates  to the criteria query
		

		TypedQuery<Course> createQuery = em.createQuery(cq.select(courseRoot));

		List<Course> resultList = createQuery.getResultList();

		logger.info("Typed Query for Courses List=   " + resultList);
	}

}
