package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.entity.FullTimeEmployee;
import com.example.demo.entity.PartTimeEmployee;

@Repository
@Transactional

public class EmployeeRepository {

	@Autowired
	EntityManager em;

	public void insert(Employee employee) {
		
		em.persist(employee);
	}
	
	public List<Employee>  getAllEmployees(){
		
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
	public List<PartTimeEmployee>  getPartTimeEmployee(){
		return em.createQuery("select e from PartTimeEmployee e",PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee>  getFullTimeEmployee(){
		return em.createQuery("select e from FullTimeEmployee e",FullTimeEmployee.class).getResultList();
	}
}
