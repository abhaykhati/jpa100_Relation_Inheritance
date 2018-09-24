package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

@Entity
public class Project {
	@TableGenerator(name = "project_gen", allocationSize = 1, pkColumnName = "gen_name", valueColumnName = "gen_val", table = "id_gen")
	@Id
	@GeneratedValue(generator = "project_gen", strategy = GenerationType.TABLE)
	private int idproject;
	private String name;

	@ManyToMany(mappedBy = "projects", cascade = CascadeType.PERSIST)
	private List<Old_Emp> employees;

	public int getIdproject() {
		return idproject;
	}

	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Old_Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Old_Emp> employees) {
		this.employees = employees;
	}
}
