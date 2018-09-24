package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
	
	
	
	public FullTimeEmployee() {
		super();
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary=salary;
	}

	private BigDecimal salary;

}
