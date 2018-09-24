package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Passport")
public class Passport {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="number")
	private String number;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="passport") //mappedBy is used to make Student owning side of relationship between Student and passport
	private Student student;

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Passport(String string) {
		// TODO Auto-generated constructor stub
	}


	public Passport() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	/*public void setId(Long id) {
		this.id = id;
	}*/


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	@Override
	public String toString() {
		return "\n Passport [id=" + id + ", number=" + number + "]";
	}


	
}
