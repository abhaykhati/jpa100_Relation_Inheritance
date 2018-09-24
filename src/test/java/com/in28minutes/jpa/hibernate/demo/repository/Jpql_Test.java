package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Demo2Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Demo2Application.class)
public class Jpql_Test {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	
	
	@Test
	public void findByIDTest() {
		
		List resultList = em.createQuery("Select c from Course c").getResultList();
		logger.info("result got =>     "+resultList);
		
		
	}
	
	
	
}
